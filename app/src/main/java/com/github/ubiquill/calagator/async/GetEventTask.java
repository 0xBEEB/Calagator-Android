package com.github.ubiquill.calagator.async;

import android.os.AsyncTask;

import com.github.ubiquill.calagator.domain.api.CalagatorService;
import com.github.ubiquill.calagator.domain.api.ServiceGenerator;
import com.github.ubiquill.calagator.domain.model.Event;
import com.github.ubiquill.calagator.utils.Config;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/25/15.
 */
public class GetEventTask extends AsyncTask<Void, Void, Event> {

    private int eventId;

    public GetEventTask(int eventId) {
        super();
        this.eventId = eventId;
    }

    @Override
    protected Event doInBackground(Void... params) {
        CalagatorService service = ServiceGenerator.createService(
                CalagatorService.class,
                Config.API_BASE);
        return service.getEvent(eventId);
    }
}
