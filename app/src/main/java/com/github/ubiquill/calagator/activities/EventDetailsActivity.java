package com.github.ubiquill.calagator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
}
