package com.tinoprojects.weatherforecastapp.controller;

import com.tinoprojects.weatherforecastapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather-forecast")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(params = {"city"})
    public ResponseEntity<Object> getWeatherInfo(@RequestParam String city){
        return ResponseEntity.ok(weatherService.getWeatherInfo(city));
    }



}
