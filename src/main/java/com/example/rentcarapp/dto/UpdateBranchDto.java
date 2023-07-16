package com.example.rentcarapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBranchDto {
    private long id;
    private String address;
    private String  staffList;
    private String  listOfCurrentlyAvailCars;
    private long reservationId ;
}
