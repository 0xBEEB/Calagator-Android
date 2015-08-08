package com.github.ubiquill.calagator.domain.calendar;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;

import com.github.ubiquill.calagator.domain.model.Event;

import java.util.Calendar;

/**
 * Created by ubiquill on 7/26/15.
 */
public class CalendarManager {

  public static void createEvent(Event event, Context context) {
    Intent intent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);

    intent.putExtra(CalendarContract.Events.TITLE, event.getTitle());
    intent.putExtra(CalendarContract.Events.DESCRIPTION, event.getDescription());
    if (event.getVenue() != null) {
      intent.putExtra(CalendarContract.Events.EVENT_LOCATION, event.getVenue().getTitle());
    }
    Calendar startTime = event.getStartDate().toGregorianCalendar();
    Calendar endTime = event.getEndDate().toGregorianCalendar();
    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());
    intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
    intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);

    context.startActivity(intent);
  }

}
