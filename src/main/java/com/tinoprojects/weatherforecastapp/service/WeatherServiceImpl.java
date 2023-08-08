package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.exception.ResourceNotFoundException;
import com.tinoprojects.weatherforecastapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.tinoprojects.weatherforecastapp.utility.SecurityUtils.getCurrentUserLogin;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    @Value("${open.weather.map.api.key}")
    private String appId;

    @Value("${open.weather.map.units}")
    private String units;

    @Value("${open.weather.map.base-url}")
    private String baseUrl;

    private final UserRepository userRepository;

    @Override
    public Object getWeatherInfo(String cityName) {
        String url = String.format("%s?q=%s&APPID=%s&units=%s", baseUrl, cityName, appId, units);
        RestTemplate restTemplate = new RestTemplate();
        log.info("Weather Data: {}", restTemplate.getForObject(url, Object.class));
        return  restTemplate.getForObject(url, Object.class);
    }

    @Override
    public Object getLoggedInUserWeatherInfo() {
        User user = userRepository.findByUsername(String.valueOf(getCurrentUserLogin()))
                .orElseThrow(()->new ResourceNotFoundException("No User Account Associated with username: "+getCurrentUserLogin()));
        String url = String.format("%s?q=%s&APPID=%s&units=%s", baseUrl, user.getCity(), appId, units);
        RestTemplate restTemplate = new RestTemplate();
        log.info("Weather Data: {}", restTemplate.getForObject(url, Object.class));
        return restTemplate.getForObject(url, Object.class);
    }
}
