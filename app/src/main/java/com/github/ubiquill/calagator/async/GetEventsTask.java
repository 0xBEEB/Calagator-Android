package com.github.ubiquill.calagator.async;

import android.os.AsyncTask;

import com.github.ubiquill.calagator.domain.api.CalagatorSearchParams;
import com.github.ubiquill.calagator.domain.api.CalagatorService;
import com.github.ubiquill.calagator.domain.api.ServiceGenerator;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.utils.Config;

import java.util.List;

/**
 * Created by ubiquill on 7/22/15.
 */
public class GetEventsTask extends AsyncTask<Void, Void, List<Event>> {

  private CalagatorSearchParams calagatorParams;

  public GetEventsTask() {
    calagatorParams = null;
  }

  public GetEventsTask(CalagatorSearchParams params) {
    this.calagatorParams = params;
  }

  @Override
  protected List<Event> doInBackground(Void... params) {
    CalagatorService service = ServiceGenerator.createService(
        CalagatorService.class,
        Config.CALAGATOR_URL);
    if (calagatorParams == null) {
      return service.getEvents();
    } else {
      return service.searchEvents(calagatorParams.getParams());
    }
  }

}
