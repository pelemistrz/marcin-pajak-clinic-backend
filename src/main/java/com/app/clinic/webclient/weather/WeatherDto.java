package com.app.clinic.webclient.weather;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class WeatherDto {
    private String description;
    @Override
    public String toString() {
        return "OpenWeatherWeatherDto{" +
                "description='" + description + '\'' +
                '}';
    }
}
