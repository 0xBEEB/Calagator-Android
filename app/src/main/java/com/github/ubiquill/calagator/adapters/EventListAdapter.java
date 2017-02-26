package com.github.ubiquill.calagator.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.ubiquill.calagator.R;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.utils.DateHelper;
import com.github.ubiquill.calagator.views.EventCardView;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/22/15.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventCardView> {

    private static LocalDate today = new LocalDate();
    private List<Event> eventList;
    private Context context;
    private int lastPosition = -1;

    public EventListAdapter(Context context, List<Event> eventList) {
        this.context = context;
        Collections.sort(eventList);
        this.eventList = removePastEvents(eventList);
    }

    @Override
    public EventCardView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.event_card, parent, false);

        return new EventCardView(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(EventCardView eventCardView, int position) {
        Event event = eventList.get(position);
        Event prevEvent = null;

        if (position > 0) {
            prevEvent = eventList.get(position - 1);
        }

        eventCardView.setEventId(event.getId());

        if (position == 0) {
            if (event.getStartDate().toLocalDate().isEqual(today)) {
                eventCardView.getDateHeader().setText("Today");
            } else {
                LocalDateTime ldt = event.getStartDate().toLocalDateTime();
                eventCardView.getDateHeader().setText(ldt.toString("E, MMM dd"));
            }
            eventCardView.getDateHeader().setVisibility(View.VISIBLE);
        } else if (
                prevEvent != null &&
                        event.getStartDate().toLocalDate().isAfter(prevEvent.getStartDate().toLocalDate())) {
            LocalDateTime ldt = event.getStartDate().toLocalDateTime();
            eventCardView.getDateHeader().setText(ldt.toString("E, MMM dd"));
            eventCardView.getDateHeader().setVisibility(View.VISIBLE);
        } else {
            eventCardView.getDateHeader().setVisibility(View.GONE);
        }

        eventCardView.getCardTitle().setText(event.getTitle());
        eventCardView.getCardTime().setText(DateHelper.getEventTimeString(event));
        eventCardView.getCardVenue().setText(EventCardView.getVenueString(event));

        setAnimation(eventCardView.itemView, position);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    @Override
    public void onViewDetachedFromWindow(EventCardView holder) {
        super.onViewDetachedFromWindow(holder);
        holder.clearAnimations();
    }

    public void updateList(List<Event> events) {
        Collections.sort(events);
        this.eventList = removePastEvents(events);
        notifyDataSetChanged();
    }

    private List<Event> removePastEvents(List<Event> events) {
        List<Event> cleanedEvents = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getStartDate() != null && !event.getStartDate().toLocalDate().isBefore(today)) {
                cleanedEvents.add(event);
            }
        }
        return cleanedEvents;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
