package com.example.rentcarapp.services.RentCar;

import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.dto.rentCar.UpdateRentCarRequest;
import com.example.rentcarapp.dto.returnCar.ReturnCarDto;
import com.example.rentcarapp.models.RentCar;

import java.util.List;

public interface RentCarService {
    RentCarDto create(CreateRentCarRequest dto);
    RentCarDto update(UpdateRentCarRequest dto);
    RentCarDto read(long id);
    void delete(long id);
    List<RentCarDto> readAll();

}
