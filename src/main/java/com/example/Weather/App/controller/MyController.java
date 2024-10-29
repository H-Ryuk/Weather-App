package com.example.Weather.App.controller;

import com.example.Weather.App.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    private final WeatherService weatherService;

    public MyController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @GetMapping("/")
    public String search(){
        return "Searching";
    }



    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        String[] weatherData = weatherService.getWeather(city);

        if (weatherData[0].equals("City not found. Please enter a valid city name.") ||
                weatherData[0].equals("Error processing data. Please try again.")) {
            model.addAttribute("errorMessage", weatherData[0]);
        } else {
            model.addAttribute("cityName", weatherData[0]);
            model.addAttribute("temperature", weatherData[1]);
            model.addAttribute("description", weatherData[2]);
            model.addAttribute("humidity", weatherData[3]);

            model.addAttribute("wind_speed", weatherData[4]);
            model.addAttribute("wind_degree", weatherData[5]);
            model.addAttribute("wind_dir", weatherData[6]);
            model.addAttribute("pressure", weatherData[7]);
            model.addAttribute("cloudcover", weatherData[8]);
            model.addAttribute("visibility", weatherData[9]);
            model.addAttribute("country", weatherData[10]);
            model.addAttribute("localtime", weatherData[11]);
        }

        return "Searching";
    }


}
