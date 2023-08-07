package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.domain.WeatherData;

public interface WeatherService {
    public WeatherData getWeatherInfo(String cityName);

}
