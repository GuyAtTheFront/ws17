package com.tfip.ibf.Workshop17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfip.ibf.Workshop17.models.Weather;
import com.tfip.ibf.Workshop17.services.WeatherService;

@Controller
public class MyController {

    @Autowired
    WeatherService weatherService;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/weather")
    public String getWeather(
        @RequestParam(required=false, defaultValue="Singapore") String city,
        Model model) {
        
        Weather weather = weatherService.getWeather(city);
        System.out.println(weather.getDetails());

        model.addAttribute("weather", weather);
        return "result";
    }

}
