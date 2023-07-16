package com.example.rentcarapp.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private Long id;
    private String Brand;
    private String Name;
    private String BodyType;
    private Long Year;
    private String Color;
    private Long Mileage;
    private Long Reservation_id;
}
