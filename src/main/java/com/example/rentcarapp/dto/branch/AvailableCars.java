package com.example.rentcarapp.dto.branch;

import com.example.rentcarapp.models.Car;
import lombok.Builder;

import java.util.List;

@Builder
public class AvailableCars {

    private long id;
    private long address;
    private List<Car>  listOfCurrentlyAvailCars;
}
