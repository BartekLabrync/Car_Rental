package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.ReturnCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ReturnCarServices {
    void returnCar(ReturnCarDto dto);
}
