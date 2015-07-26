package com.github.ubiquill.calagator;

import com.github.ubiquill.calagator.domain.api.CalagatorService;
import com.github.ubiquill.calagator.domain.api.ServiceGenerator;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.domain.model.Venue;
import com.google.common.util.concurrent.SettableFuture;

import junit.framework.TestCase;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.github.ubiquill.calagator.utils.Config.CALAGATOR_URL;

/**
 * Created by ubiquill on 7/20/15.
 */
public class CalagatorApiTest extends TestCase {
  CalagatorService service;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    service = ServiceGenerator.createService(CalagatorService.class, CALAGATOR_URL);
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public final void testGetEvents() throws Exception {
    final SettableFuture<Boolean> future = SettableFuture.create();
    service.getEvents(new Callback<List<Event>>() {
      @Override
      public void success(List<Event> events, Response response) {
        future.set(events.size() > 0);
      }

      @Override
      public void failure(RetrofitError error) {
        future.set(false);
      }
    });
    assertTrue("Events Returned", future.get());
  }

  public final void testGetVenues() throws Exception {
    final SettableFuture<Boolean> future = SettableFuture.create();
    service.getVenues(new Callback<List<Venue>>() {
      @Override
      public void success(List<Venue> events, Response response) {
        future.set(events.size() > 0);
      }

      @Override
      public void failure(RetrofitError error) {
        future.set(false);
      }
    });
    assertTrue("Venues Returned", future.get());
  }
}
