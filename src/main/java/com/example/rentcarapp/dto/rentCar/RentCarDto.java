package com.example.rentcarapp.dto.rentCar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentCarDto {
    private long id;
    private String employee;
    private LocalDate rentalDate;
    private String comments;
    private long reservationId;
}
