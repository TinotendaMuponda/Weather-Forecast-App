package com.tinoprojects.weatherforecastapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    @Value("${open.weather.map.api.key}")
    private String appId;

    @Value("${open.weather.map.units}")
    private String units;

    @Value("${open.weather.map.base-url}")
    private String baseUrl;

    @Override
    public Object getWeatherInfo(String cityName) {
        String url = String.format("%s?q=%s&APPID=%s&units=%s", baseUrl, cityName, appId, units);
        RestTemplate restTemplate = new RestTemplate();
        log.info("Weather Data: {}", restTemplate.getForObject(url, Object.class));
        return restTemplate.getForObject(url, Object.class);
    }
}
