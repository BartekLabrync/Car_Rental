package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.dto.returnCar.ReturnCarDto;

import java.util.List;

public interface RentCarService {
    RentCarDto create(RentCarDto dto);
    RentCarDto update(RentCarDto dto);
    RentCarDto read(long id);
    void delete(RentCarDto dto);
    List<RentCarDto> readAll();

}
