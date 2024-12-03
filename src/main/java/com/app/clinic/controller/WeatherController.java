package com.app.clinic.controller;

import com.app.clinic.webclient.WeatherClient;
import com.app.clinic.webclient.weather.OpenWeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherClient client;
    @GetMapping
    public OpenWeatherDto getWeather(@RequestParam String city) {
        return client.getWeather(city);
    }
}
