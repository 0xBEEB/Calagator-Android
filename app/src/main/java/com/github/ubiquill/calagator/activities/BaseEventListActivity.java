package com.github.ubiquill.calagator.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.adapters.EventListAdapter;
import com.github.ubiquill.calagator.async.GetEventsTask;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.utils.Network;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * BaseEventListActivity
 * (C) 2015 by Briar Rose Schreiber <ubiquill@riseup.net>
 * See LICENSE for use
 *
 * This abscract class sets up the views for any activity that want to list multiple events.
 */
public abstract class BaseEventListActivity extends AppCompatActivity {
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @Bind(R.id.eventList)
    RecyclerView eventList;
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
        eventListAdapter = new EventListAdapter(this, new ArrayList<Event>());
        eventList.setAdapter(eventListAdapter);

        if (isRefreshable()) {
            swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refreshEvents();
                }
            });
            refreshEvents();
        }
    }

    protected boolean isRefreshable() {
        swipeRefresh.setEnabled(true);
        return true;
    }

    private void refreshEvents() {
        if (Network.isNetworkAvailable(this)) {
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
                    if (eventListAdapter.getItemCount() < 1) {
                        Snackbar.make(
                                findViewById(android.R.id.content),
                                getResources().getString(R.string.no_events),
                                Snackbar.LENGTH_LONG).show();
                    }
                    swipeRefresh.setRefreshing(false);
                }

            };
            task.execute();
        } else {
            swipeRefresh.setRefreshing(false);
            Snackbar.make(
                    findViewById(android.R.id.content),
                    getResources().getString(R.string.no_network),
                    Snackbar.LENGTH_LONG).show();
        }
    }
}
