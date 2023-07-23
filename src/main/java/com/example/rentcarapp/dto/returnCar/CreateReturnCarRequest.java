package com.example.rentcarapp.dto.returnCar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReturnCarRequest {
    private long id;
    private long employee;
    private LocalDate dateOfReturn;
    private String additionalFees;
    private String comments;
    private long reservationId;
}
