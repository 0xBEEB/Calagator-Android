package com.github.ubiquill.calagator.domain.api;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/20/15.
 */
public class CalagatorSearchParamsBuilder {

    private String query;
    private CalagatorSearchOrder order;
    private String tag;

    public CalagatorSearchParamsBuilder() {
        setQuery(null);
        setTag(null);
        setOrder(null);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setOrder(CalagatorSearchOrder order) {
        this.order = order;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public CalagatorSearchParams build() throws IllegalArgumentException {
        return new CalagatorSearchParams(query, tag, order);
    }
}
