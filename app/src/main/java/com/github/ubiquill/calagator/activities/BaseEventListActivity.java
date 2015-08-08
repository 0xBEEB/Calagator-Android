package com.github.ubiquill.calagator.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.adapters.EventListAdapter;
import com.github.ubiquill.calagator.async.GetEventsTask;
import com.github.ubiquill.calagator.domain.model.Event;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ubiquill on 7/23/15.
 */
public abstract class BaseEventListActivity extends AppCompatActivity {
  @Bind(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
  @Bind(R.id.eventList) RecyclerView eventList;
  EventListAdapter eventListAdapter;

  protected abstract int setContentView();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(setContentView());

    ButterKnife.bind(this);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    eventList.setLayoutManager(llm);
    eventListAdapter = new EventListAdapter(new ArrayList<Event>());
    eventList.setAdapter(eventListAdapter);
    eventList.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      }
    });

    refreshEvents();

    swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        refreshEvents();
      }
    });
  }

  private void refreshEvents() {
    swipeRefresh.post(new Runnable() {
      @Override
      public void run() {
        if (swipeRefresh != null) {
          swipeRefresh.setRefreshing(true);
        }
      }
    });

    GetEventsTask task = new GetEventsTask() {

      @Override
      protected void onPostExecute(List<Event> events) {
        super.onPostExecute(events);
        eventListAdapter.updateList(events);
        swipeRefresh.setRefreshing(false);
      }

    };
    task.execute();
  }
}
