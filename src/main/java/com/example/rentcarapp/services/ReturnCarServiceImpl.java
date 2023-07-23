package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.returnCar.ReturnCarDto;
import com.example.rentcarapp.models.ReturnCar;
import com.example.rentcarapp.repositories.ReturnCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReturnCarServiceImpl implements ReturnCarService {
    private final ReturnCarRepository returnCarRepository;

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
    @Override
    public void returnCar(ReturnCarDto dto) {
        var model = toModel(dto);
        returnCarRepository.save(model);
    }

    @Override
    public ReturnCarDto create(ReturnCarDto dto) {
        var model = toModel(dto);
        return toDto(returnCarRepository.save(model));
    }

    @Override
    public ReturnCarDto update(ReturnCarDto dto) {
        return null;
    }

    @Override
    public ReturnCarDto read(long id) {
        return null;
    }

    @Override
    public void delete(ReturnCarDto dto) {

    }

    @Override
    public List<ReturnCarDto> readAll() {
        return null;
    }


}
