package com.app.clinic.webclient.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class OpenWeatherDto {

    private MainDto main;
    private List<WeatherDto> weather;

    @Override
    public String toString() {
        return "Dto{" +

                ", main=" + main +
                ", weather=" + weather +
                '}';
    }
}

