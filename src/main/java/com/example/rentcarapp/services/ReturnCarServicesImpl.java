package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.ReturnCarDto;
import com.example.rentcarapp.models.ReturnCar;
import com.example.rentcarapp.repositories.ReturnCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReturnCarServicesImpl implements ReturnCarServices {
    private final ReturnCarRepository returnCarRepository;

    @Override
    public void returnCar(ReturnCarDto dto) {
        var model = toModel(dto);
        returnCarRepository.save(model);
    }
    private ReturnCarDto toDto(ReturnCar model){
        ReturnCarDto dto = ReturnCarDto.builder()
                .id(model.getId())
                .additionalFees(model.getAdditionalFees())
                .dateOfReturn(model.getDateOfReturn())
                .employee(model.getEmployee())
                .reservationId(model.getReservationId())
                .comments(model.getComments())
                .build();
        return dto;
    }
    private ReturnCar toModel(ReturnCarDto dto){
        ReturnCar model = ReturnCar.builder()
                .id(dto.getId())
                .additionalFees(dto.getAdditionalFees())
                .dateOfReturn(dto.getDateOfReturn())
                .employee(dto.getEmployee())
                .reservationId(dto.getReservationId())
                .comments(dto.getComments())
                .build();
        return model;
    }
}
