package com.github.ubiquill.calagator.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.async.GetEventsTask;
import com.github.ubiquill.calagator.domain.api.CalagatorSearchParams;
import com.github.ubiquill.calagator.domain.api.CalagatorSearchParamsBuilder;
import com.github.ubiquill.calagator.domain.model.Event;

import java.util.List;

import butterknife.Bind;

/**
 * Created by ubiquill on 7/23/15.
 */
public class SearchEventsActivity extends BaseEventListActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int setContentView() {
        return R.layout.activity_search_events;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupToolbar();

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            handleSearch(query);
        }
    }

    private void handleSearch(String query) {
        CalagatorSearchParams params;
        if (query == null || query.length() < 1) {
            params = null;
        } else {
            CalagatorSearchParamsBuilder paramsBuilder = new CalagatorSearchParamsBuilder();
            if (query.startsWith("#")) {
                String tag = query.substring(1);
                paramsBuilder.setTag(tag);
            } else {
                paramsBuilder.setQuery(query);
            }
            params = paramsBuilder.build();
        }

        GetEventsTask task = new GetEventsTask(params) {

            @Override
            protected void onPostExecute(List<Event> eventList) {
                eventListAdapter.updateList(eventList);
            }
        };
        task.execute();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowCustomEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_events, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) SearchEventsActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(SearchEventsActivity.this.getComponentName()));
            searchView.setIconifiedByDefault(true);
            searchView.setIconified(false);
            searchView.setFocusable(true);
            searchView.requestFocusFromTouch();
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
