package com.github.ubiquill.calagator.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.github.ubiquill.calagator.R;

import butterknife.Bind;

public class MainActivity extends BaseEventListActivity
        implements AppBarLayout.OnOffsetChangedListener {

    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.search_button)
    FloatingActionButton searchButton;
    View.OnClickListener searchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent searchIntent = new Intent(getApplicationContext(), SearchEventsActivity.class);
            startActivity(searchIntent);
        }
    };

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        collapsingToolbar.setTitle(getResources().getString(R.string.app_name));
        searchButton.setOnClickListener(searchClickListener);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        swipeRefresh.setEnabled(i == 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        appbar.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appbar.removeOnOffsetChangedListener(this);
    }

}