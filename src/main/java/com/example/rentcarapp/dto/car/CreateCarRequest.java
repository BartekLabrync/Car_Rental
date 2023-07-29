package com.example.rentcarapp.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

    private Long id;
    private String brand;
    private String name;
    private String bodyType;
    private Long year;
    private String color;
    private Long mileage;
    private Long reservation_id;
}
