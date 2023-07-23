package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.dto.rentCar.UpdateRentCarRequest;
import com.example.rentcarapp.models.RentCar;
import com.example.rentcarapp.repositories.RentCarRepository;
import com.example.rentcarapp.repositories.ReservationsRepository;
import com.example.rentcarapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentCarServiceImpl implements RentCarService{
    private final RentCarRepository rentCarRepository;
    private final UserRepository userRepository;
    private final ReservationsRepository reservationsRepository;


    private RentCarDto toDto (RentCar model){
        RentCarDto dto = RentCarDto.builder()
                .id(model.getId())
                .employee(model.getEmployee().getId())
                .rentalDate(model.getRentalDate())
                .comments(model.getComments())
                .reservationId(model.getReservation().getId())
                .build();
        return dto;
    }
    private RentCar toModel (RentCarDto dto){
        RentCar model = RentCar.builder()
                .id(dto.getId())
                .employee(userRepository.getReferenceById(dto.getEmployee()))
                .rentalDate(dto.getRentalDate())
                .comments(dto.getComments())
                .reservation(reservationsRepository.getReferenceById(dto.getReservationId()))
                .build();
        return model;
    }

    public RentCar fromConvertToModel(CreateRentCarRequest dto){
        RentCar model = RentCar.builder()
                .id(dto.getId())
                .employee(userRepository.getReferenceById(dto.getEmployee()))
                .rentalDate(dto.getRentalDate())
                .comments(dto.getComments())
                .reservation(reservationsRepository.getReferenceById(dto.getReservationId()))
                .build();
        return model;
    }
    public RentCar convertToModel(UpdateRentCarRequest dto){
        RentCar model = RentCar.builder()
                .id(dto.getId())
                .employee(userRepository.getReferenceById(dto.getEmployee()))
                .rentalDate(dto.getRentalDate())
                .comments(dto.getComments())
                .reservation(reservationsRepository.getReferenceById(dto.getReservationId()))
                .build();
        return model;
    }

    @Override
    public  RentCarDto create(RentCar model) {
        return toDto(rentCarRepository.save(model));
    }

    @Override
    public RentCarDto update(UpdateRentCarRequest dto) {
        var model = convertToModel(dto);
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
    public void delete(long id) {
        rentCarRepository.deleteById(id);

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
