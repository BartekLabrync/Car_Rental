package com.example.rentcarapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReturnCarRequest {
    private long id;
    private String employee;
    private LocalDate dateOfReturn;
    private String additionalFees;
    private String comments;
    private long reservationId;
}
