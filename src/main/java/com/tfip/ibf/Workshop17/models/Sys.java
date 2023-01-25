package com.tfip.ibf.Workshop17.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {
    private long sunrise;
    private long sunset;

    public long getSunrise() {
        return sunrise;
    }
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }
    public long getSunset() {
        return sunset;
    }
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
    @Override
    public String toString() {
        return "Sys [sunrise=" + sunrise + ", sunset=" + sunset + "]";
    }
}
