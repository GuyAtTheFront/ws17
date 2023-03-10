package com.tfip.ibf.Workshop17.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private int pressure;
    private int humidity;
    
    @Override
    public String toString() {
        return "Main [temp=" + temp + ", feels_like=" + feels_like + ", temp_min=" + temp_min + ", temp_max=" + temp_max
                + ", pressure=" + pressure + ", humidity=" + humidity + "]";
    }
    
    public float getTemp() {
        return temp;
    }
    public void setTemp(float temp) {
        this.temp = temp;
    }
    public float getFeels_like() {
        return feels_like;
    }
    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }
    public float getTemp_min() {
        return temp_min;
    }
    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }
    public float getTemp_max() {
        return temp_max;
    }
    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
    public int getPressure() {
        return pressure;
    }
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

 
}
