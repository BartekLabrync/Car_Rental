package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.models.RentCar;
import com.example.rentcarapp.repositories.RentCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentCarServiceImpl implements RentCarService{
    private final RentCarRepository rentCarRepository;

    @Override
    public void rentCar(RentCarDto dto) {
        var model = toModel(dto);
        rentCarRepository.save(model);
    }
    private RentCarDto toDto (RentCar model){
        RentCarDto dto = RentCarDto.builder()
                .id(model.getId())
                .employee(model.getEmployee())
                .rentalDate(model.getRentalDate())
                .comments(model.getComments())
                .reservationId(model.getReservationId())
                .build();
        return dto;
    }
    private RentCar toModel (RentCarDto dto){
        RentCar model = RentCar.builder()
                .id(dto.getId())
                .employee(dto.getEmployee())
                .rentalDate(dto.getRentalDate())
                .comments(dto.getComments())
                .reservationId(dto.getReservationId())
                .build();
        return model;
    }

}
