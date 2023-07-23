package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.returnCar.ReturnCarDto;

import java.util.List;


public interface ReturnCarService {
    void returnCar(ReturnCarDto dto);
    ReturnCarDto create(ReturnCarDto dto);
    ReturnCarDto update(ReturnCarDto dto);
    ReturnCarDto read(long id);
    void delete(ReturnCarDto dto);
    List<ReturnCarDto> readAll();
}
