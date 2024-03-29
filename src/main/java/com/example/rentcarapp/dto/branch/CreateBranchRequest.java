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
@NoArgsConstructor
@AllArgsConstructor
public class CreateBranchRequest {

    private long id;
    private long address;
//    private List<User> staffList;
//    private List<Car> listOfCurrentlyAvailCars;
    private long mainRental;
    //private long reservationId;

}
