package com.tfip.ibf.Workshop17.services;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfip.ibf.Workshop17.models.Detail;
import com.tfip.ibf.Workshop17.models.Main;
import com.tfip.ibf.Workshop17.models.Sys;
import com.tfip.ibf.Workshop17.models.Weather;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class WeatherService {
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String API_KEY = "476e23fe1116f4e69d2a3e68672604e1";

    public Weather getWeather(String city) {
        // 1. build URL
        // 2. build request entity with URL and headers
        // 3. instantiate RestTemplate
        // 4. use RestTemplate to exchange RequestEntity for ResponseEntity
        // 5. ResponseEntity.body to get json
        // 6. Unpack json to Model

        String url = UriComponentsBuilder
            .fromUriString(BASE_URL)
            .queryParam("q", city)
            .queryParam("units", "metric")
            .queryParam("appid", API_KEY)
            .toUriString();

        RequestEntity<Void> request = RequestEntity
                                        .get(url)
                                        .accept(MediaType.APPLICATION_JSON)
                                        .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> response = template.exchange(request, String.class);

        // // Ignore this, for fun
        // Weather weather = this.unpackJsonWithMapper(response.getBody());
        
        Weather weather = this.unpackJsonWithJsonObject(response.getBody());

        // TODO: Error Handling, error when not found <-- bad code, bad!
        return weather;
    }

    private Weather unpackJsonWithJsonObject(String json){

        Weather weather = new Weather();
        
        try(InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject data = reader.readObject();
            
            System.out.println("setting main...");
            Main main = new Main();
            main.setTemp(data.getJsonObject("main").getJsonNumber("temp").bigDecimalValue().floatValue());
            main.setFeels_like(data.getJsonObject("main").getJsonNumber("feels_like").bigDecimalValue().floatValue());
            main.setTemp_min(data.getJsonObject("main").getJsonNumber("temp_min").bigDecimalValue().floatValue());
            main.setTemp_max(data.getJsonObject("main").getJsonNumber("temp_max").bigDecimalValue().floatValue());
            main.setPressure(data.getJsonObject("main").getInt("pressure"));
            main.setHumidity(data.getJsonObject("main").getInt("humidity"));
            System.out.println(main);

            Sys sys = new Sys();
            sys.setSunrise(data.getJsonObject("sys").getJsonNumber("sunrise").longValue());
            sys.setSunset(data.getJsonObject("sys").getJsonNumber("sunset").longValue());
            System.out.println(sys);

            List<Detail> details = new LinkedList<>();
            Detail detail = new Detail();
            detail.setDescription(data.getJsonArray("weather").getJsonObject(0).getString("description"));
            detail.setIcon(data.getJsonArray("weather").getJsonObject(0).getString("icon"));
            detail.setMain(data.getJsonArray("weather").getJsonObject(0).getString("main"));
            System.out.println(detail);
            details.add(detail);

            weather.setName(data.getString("name"));
            weather.setDt(data.getJsonNumber("dt").longValue());
            weather.setMain(main);
            weather.setDetails(details);
            weather.setSys(sys);
            System.out.println(weather);

        } catch (Exception e) {
            return null;
        }

        return weather;
    }

    // Ignore this, for fun
    private Weather unpackJsonWithMapper(String json) {

        ObjectMapper mapper = new ObjectMapper();
        Weather weather = null;

        try {
            weather = mapper.readValue(json, Weather.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        return weather;
    }
}
