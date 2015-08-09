package com.github.ubiquill.calagator.domain.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Briar Rose Schreiber <ubiquill@riseup.net> on 7/20/15.
 */
public class CalagatorSearchParams {
    private String query;
    private CalagatorSearchOrder order;
    private String tag;

    public CalagatorSearchParams(String query, String tag, CalagatorSearchOrder order) {
        if (query == null ^ tag == null) {
            this.query = query;
            this.tag = tag;
            this.order = order;
        } else {
            throw new IllegalArgumentException("query or tag (but not both are required");
        }
    }

    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap();
        if (query != null) {
            params.put("query", query);
        }
        if (tag != null) {
            params.put("tag", tag);
        }
        if (order != null && order.includeOrder()) {
            params.put("order", order.getTerm());
        }
        return params;
    }
}
