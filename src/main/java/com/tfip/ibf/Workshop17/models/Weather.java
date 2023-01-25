package com.tfip.ibf.Workshop17.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("weather")
    private List<Detail> details;
    private Main main;
    private long dt;
    private Sys sys;
    private String name;
    
    public List<Detail> getDetails() {
        return details;
    }
    public void setDetails(List<Detail> details) {
        System.out.println("details --> setter");
        this.details = details;
    }
    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public long getDt() {
        return dt;
    }
    public void setDt(long dt) {
        this.dt = dt;
    }
    public Sys getSys() {
        return sys;
    }
    public void setSys(Sys sys) {
        this.sys = sys;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Weather [details=" + details + ", main=" + main + ", dt=" + dt + ", sys=" + sys + ", name=" + name + "]";
    }

    
}
