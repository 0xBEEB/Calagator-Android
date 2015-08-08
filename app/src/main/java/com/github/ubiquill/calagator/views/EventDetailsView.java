package com.github.ubiquill.calagator.views;

import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.commonsware.cwac.anddown.AndDown;
import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.utils.DateHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ubiquill on 7/25/15.
 */
public class EventDetailsView {

  private View view;
  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.eventTitle) TextView eventTitle;
  @Bind(R.id.eventDate) TextView eventDate;
  @Bind(R.id.eventTime) TextView eventTime;
  @Bind(R.id.venueSection) LinearLayout venueSection;
  @Bind(R.id.venueName) TextView venueName;
  @Bind(R.id.venueAddress) TextView venueAddress;
  @Bind(R.id.map) ImageView map;
  @Bind(R.id.venueAccessSection) LinearLayout venueAccessSection;
  @Bind(R.id.venueAccessInfo) TextView venueAccessInfo;
  @Bind(R.id.eventDetails) TextView eventDetails;
  @Bind(R.id.bottom_area) LinearLayout bottomArea;

  public EventDetailsView(View view) {
    this.view = view;
    ButterKnife.bind(this, view);

    toolbar.setTitle(view.getContext().getResources().getString(R.string.app_name));
  }

  public void bindEvent(Event event) {
    eventTitle.setText(event.getTitle());
    eventDate.setText(event.getStartDate().toString("E, MMM dd"));
    eventTime.setText(DateHelper.getEventTimeString(event));
    bottomArea.setVisibility(View.VISIBLE);
    if (event.getVenue() != null) {
      venueSection.setVisibility(View.VISIBLE);
      venueName.setText(event.getVenue().getTitle());
      venueAddress.setText(event.getVenue().getStreetAddress());

      if (event.getVenue().getStaticMapURL() != null) {
        Glide.with(view.getContext()).load(event.getVenue().getStaticMapURL()).into(map);
      } else {
        map.setVisibility(View.GONE);
      }

      if (event.getVenue().getAccessNotes() != null
          && event.getVenue().getAccessNotes().length() > 0) {
        venueAccessSection.setVisibility(View.VISIBLE);
        venueAccessInfo.setText(event.getVenue().getAccessNotes());
      } else {
        venueAccessSection.setVisibility(View.GONE);
      }
    } else {
      venueSection.setVisibility(View.GONE);
    }
    AndDown result = new AndDown();
    String html = result.markdownToHtml(event.getDescription());
    eventDetails.setText(Html.fromHtml(html));
  }

}
