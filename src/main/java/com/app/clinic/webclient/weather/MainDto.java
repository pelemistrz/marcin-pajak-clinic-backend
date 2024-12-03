package com.app.clinic.webclient.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MainDto {
    private double temp;

    @Override
    public String toString() {
        return "OpenWeatherMainDto{" +
                "temp=" + temp +
                '}';
    }
}