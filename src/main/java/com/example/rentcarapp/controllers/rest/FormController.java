package com.example.rentcarapp.controllers.rest;

import com.example.rentcarapp.models.WeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FormController {

//    @GetMapping("/weather")
//    public WeatherData weather(@RequestParam String branch) {
//        RestTemplate restTemplate = new RestTemplate();
//        String weatherApiUrl = "https://api.weatherapi.com/v1/current.json?key=20ef7e389f434c7981c90153233007&q=" + branch;
//
//        ResponseEntity<WeatherData> response = restTemplate.getForEntity(weatherApiUrl, WeatherData.class);
//
//        return response.getBody();
//    }

    @PostMapping("/weather")
    public String pogoda (@RequestParam String branch) {
        return "Weather";
    }
}
