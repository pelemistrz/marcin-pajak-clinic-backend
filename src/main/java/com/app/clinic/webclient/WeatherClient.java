package com.app.clinic.webclient;

import com.app.clinic.webclient.weather.OpenWeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class WeatherClient {
    private final RestTemplate restTemplate;
    @Value("${weather.api.endpoint.prod}")
    private String weatherEndpoint;
    @Value("${weather.app.token}")
    private String appToken;

    public OpenWeatherDto getWeather(String city) {

        OpenWeatherDto weather = restTemplate.getForObject(
                weatherEndpoint+city+",pl&appid="+appToken+"&units=metric&lang=pl"
          ,OpenWeatherDto.class
        );
        return weather;
    }
}
