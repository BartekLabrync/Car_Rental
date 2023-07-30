package com.example.rentcarapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {

    private String name;
    private String country;
    private Double temp_c;
    private String condition;

}

