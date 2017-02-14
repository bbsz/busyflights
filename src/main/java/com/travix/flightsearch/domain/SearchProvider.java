package com.travix.flightsearch.domain;

/**
 * Created by sergej on 12.2.2017.
 */
public enum SearchProvider {
    CRAZY_AIR("CA"), TOUGH_JET("TJ");

    private String code;

    private SearchProvider(String code) {
        this.code = code;
    }
}
