package com.github.ubiquill.calagator.utils;

import com.github.ubiquill.calagator.domain.model.Event;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Created by ubiquill on 7/23/15.
 */
public class DateHelper {

  public static DateTime fromISOTimeStamp(String ts) {
    DateTimeFormatter parser = ISODateTimeFormat.dateTime();
    DateTime dt = parser.parseDateTime(ts);
    return dt;
  }

  public static String getEventTimeString(Event event) {
    String timeString = "";

    if (event.getStartTime() != null) {
      LocalDateTime dtStart = event.getStartDate().toLocalDateTime();
      timeString += dtStart.toString("hh:mm aa");
    }

    if (event.getEndTime() != null) {
      timeString += " - ";
      LocalDateTime dtEnd = event.getEndDate().toLocalDateTime();
      timeString += dtEnd.toString("hh:mm aa");
    }

    return timeString;
  }
}
