package com.example.rentcarapp.dto.branch;

import com.example.rentcarapp.models.Address;
import com.example.rentcarapp.models.Car;
import com.example.rentcarapp.models.MainRental;
import com.example.rentcarapp.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

    private long id;
    private Address address;
    private List<User> staffList;
    private List<Car> listOfCurrentlyAvailCars;
    private MainRental mainRental;
    //private long reservationId;

}
