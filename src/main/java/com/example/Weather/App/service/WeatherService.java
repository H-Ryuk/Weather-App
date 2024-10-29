package com.example.Weather.App.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weatherstack.api.key}")
    private String apiKey;




    public String[] getWeather(String city) {
        String url = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + city;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        String cityName = "";
        String temperature = "";
        String humidity = "";
        String description = "";
        String country = "";
        String locationtime = "";
        String windSpeed = "";
        String windDegree = "";
        String windDir = "";
        String pressure = "";
        String cloudCover = "";
        String visibility = "";
        String errorMessage = "City not found. Please enter a valid city name.";

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            if (root.has("success") && !root.get("success").asBoolean()) {
                return new String[] { errorMessage, "", "", "" };
            }

            cityName = root.path("location").path("name").asText();
            temperature = root.path("current").path("temperature").asText();
            description = root.path("current").path("weather_descriptions").get(0).asText();
            humidity = root.path("current").path("humidity").asText();

            windSpeed = root.path("current").path("wind_speed").asText();
            windDegree = root.path("current").path("wind_degree").asText();
            windDir = root.path("current").path("wind_dir").asText();
            pressure = root.path("current").path("pressure").asText();
            cloudCover = root.path("current").path("cloudcover").asText();
            visibility = root.path("current").path("visibility").asText();
            country = root.path("location").path("country").asText();
            locationtime = root.path("location").path("localtime").asText();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new String[] { "Error processing data. Please try again.", "", "", "" };
        }

        return new String[]{
                cityName, temperature,
                description, humidity,
                windSpeed, windDegree,
                windDir, pressure,
                cloudCover, visibility,
                country, locationtime};
    }
}
