package com.github.ubiquill.calagator.domain.api;

import retrofit.RestAdapter;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/20/15.
 */
public final class ServiceGenerator {

    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(baseUrl);

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
