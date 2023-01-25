package com.tfip.ibf.Workshop17.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail {
    private String main;
    private String description;
    private String icon;

    public String getMain() {
        return main;
    }
    public void setMain(String main) {
        System.out.println("setter");
        this.main = main;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    @Override
    public String toString() {
        return "Detail [main=" + main + ", description=" + description + ", icon=" + icon + "]";
    }

    
}
