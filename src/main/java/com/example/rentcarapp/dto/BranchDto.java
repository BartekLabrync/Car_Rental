package com.example.rentcarapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

    private  long id;
    private String address;

  //  private List<User> staffList;
  //  private List<> listOfCurrentlyAvailCars;
    private long reservationId ;
}
