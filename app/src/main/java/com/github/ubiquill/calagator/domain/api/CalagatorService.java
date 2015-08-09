package com.github.ubiquill.calagator.domain.api;

import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.domain.model.Venue;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/20/15.
 */
public interface CalagatorService {

    @GET("/events.json")
    void getEvents(Callback<List<Event>> callback);

    @GET("/events.json")
    List<Event> getEvents();

    @GET("/events/{id}.json")
    void getEvent(@Path("id") int eventId, Callback<Event> callback);

    @GET("/events/{id}.json")
    Event getEvent(@Path("id") int eventId);

    @GET("/events/search.json")
    void searchEvents(@QueryMap Map<String, String> options, Callback<List<Event>> callback);

    @GET("/events/search.json")
    List<Event> searchEvents(@QueryMap Map<String, String> options);

    @GET("/venues.json")
    void getVenues(Callback<List<Venue>> callback);

    @GET("/venues.json")
    List<Venue> getVenues();

    @GET("/venues/{id}.json")
    void getVenue(@Path("id") int venueId, Callback<Venue> callback);

    @GET("/venues/{id}.json")
    Venue getVenue(@Path("id") int venueId);
}
