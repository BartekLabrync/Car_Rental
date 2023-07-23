package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.models.RentCar;
import com.example.rentcarapp.repositories.RentCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentCarServiceImpl implements RentCarService{
    private final RentCarRepository rentCarRepository;


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

    @Override
    public  RentCarDto create(RentCarDto dto) {
        var model = toModel(dto);
        return toDto(rentCarRepository.save(model));

    }

    @Override
    public RentCarDto update(RentCarDto dto) {
        var model = toModel(dto);
        return toDto(rentCarRepository.save(model));
    }

    @Override
    public RentCarDto read(long id) {
        return rentCarRepository
                .findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public void delete(RentCarDto dto) {
        var model = toModel(dto);
        rentCarRepository.delete(model);

    }

    @Override
    public List<RentCarDto> readAll() {
        return rentCarRepository
                .findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
