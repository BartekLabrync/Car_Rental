package com.example.rentcarapp.services.returnCar;

import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.returnCar.CreateReturnCarRequest;
import com.example.rentcarapp.dto.returnCar.ReturnCarDto;
import com.example.rentcarapp.dto.returnCar.UpdateReturnCarRequest;
import com.example.rentcarapp.models.ReturnCar;

import java.util.List;


public interface ReturnCarService {
    void returnCar(ReturnCarDto dto);

    ReturnCarDto create(CreateReturnCarRequest dto);
    ReturnCarDto update(UpdateReturnCarRequest dto);
    ReturnCarDto read(long id);
    void delete(long id);
    List<ReturnCarDto> readAll();
}
