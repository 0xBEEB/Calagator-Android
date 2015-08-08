package com.github.ubiquill.calagator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.async.GetEventTask;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.views.EventDetailsView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ubiquill on 7/25/15.
 */
public class EventDetailsActivity extends AppCompatActivity {

  @Bind(R.id.toolbar) Toolbar toolbar;

  private int eventId;
  private Event event;
  private EventDetailsView detailsView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    eventId = getIntent().getIntExtra("eventId",-1);

    setContentView(R.layout.activity_event_details);
    detailsView = new EventDetailsView(findViewById(R.id.eventDetailsLayout));

    ButterKnife.bind(this);

    setupToolbar();
  }

  @Override
  protected void onResume() {
    super.onResume();
    if (eventId > 0) {
      GetEventTask task = new GetEventTask(eventId) {
        @Override
        protected void onPostExecute(Event event) {
          super.onPostExecute(event);
          EventDetailsActivity.this.event = event;
          detailsView.bindEvent(event);
        }
      };
      task.execute();
    }
  }

  private void setupToolbar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
    getSupportActionBar().setDisplayShowCustomEnabled(false);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(false);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.event_details, menu);
    MenuItem searchItem = menu.findItem(R.id.action_insert_calendar);


    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch(item.getItemId()) {
      case R.id.action_insert_calendar:
        insertEvent();
        break;
      default:

    }
    return super.onOptionsItemSelected(item);
  }

  private void insertEvent() {
    if (event == null) {
      return;
    }
    Intent intent = new Intent(Intent.ACTION_EDIT);
    intent.setType("vnd.android.cursor.item/event");
    if (event.getStartDate() != null) {
      intent.putExtra("beginTime", event.getStartDate().toDateTime().getMillis());
    }
    if (event.getEndDate() != null) {
      intent.putExtra("endTime", event.getEndDate().toDateTime().getMillis());
    }
    intent.putExtra("title", event.getTitle());
    intent.putExtra("eventLocation", event.getVenue().getStreetAddress());
    startActivity(intent);
  }
}
