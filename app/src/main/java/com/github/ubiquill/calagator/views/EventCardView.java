package com.github.ubiquill.calagator.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.activities.EventDetailsActivity;
import com.github.ubiquill.calagator.domain.model.Event;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/22/15.
 */
public class EventCardView extends RecyclerView.ViewHolder {

    @Bind(R.id.date_header)
    protected TextView dateHeader;
    @Bind(R.id.card_view)
    protected CardView cardView;
    @Bind(R.id.title)
    protected TextView cardTitle;
    @Bind(R.id.time)
    protected TextView cardTime;
    @Bind(R.id.venue)
    protected TextView cardVenue;

    int eventId;
    Context context;

    public EventCardView(View view, Context context) {
        super(view);
        this.context = context;
        this.eventId = -1;
        ButterKnife.bind(this, view);

        setCardViewOnClickListener();
    }

    public static String getVenueString(Event event) {
        if (event.getVenue() != null && event.getVenue().getTitle() != null) {
            return event.getVenue().getTitle();
        }
        return "";
    }

    public CardView getCardView() {
        return cardView;
    }

    public TextView getCardTitle() {
        return cardTitle;
    }

    public TextView getDateHeader() {
        return dateHeader;
    }

    public TextView getCardVenue() {
        return cardVenue;
    }

    public TextView getCardTime() {
        return cardTime;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setCardViewOnClickListener() {
        getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eventId < 0) {
                    return;
                }
                Intent eventDetailIntent = new Intent(context, EventDetailsActivity.class);
                eventDetailIntent.putExtra("eventId", eventId);
                context.startActivity(eventDetailIntent);
            }
        });
    }
}
