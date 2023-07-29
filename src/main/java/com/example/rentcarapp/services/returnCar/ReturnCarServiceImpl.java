package com.example.rentcarapp.services.returnCar;

import com.example.rentcarapp.dto.returnCar.CreateReturnCarRequest;
import com.example.rentcarapp.dto.returnCar.ReturnCarDto;
import com.example.rentcarapp.dto.returnCar.UpdateReturnCarRequest;
import com.example.rentcarapp.models.ReturnCar;
import com.example.rentcarapp.repositories.ReservationsRepository;
import com.example.rentcarapp.repositories.ReturnCarRepository;
import com.example.rentcarapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReturnCarServiceImpl implements ReturnCarService {
    private final ReturnCarRepository returnCarRepository;
    private final UserRepository userRepository;
    private final ReservationsRepository reservationsRepository;

    private ReturnCarDto toDto(ReturnCar model){
        ReturnCarDto dto = ReturnCarDto.builder()
                .id(model.getId())
                .additionalFees(model.getAdditionalFees())
                .dateOfReturn(model.getDateOfReturn())
                .employee(model.getEmployee().getId())
                .reservationId(model.getReservation().getId())
                .comments(model.getComments())
                .build();
        return dto;
    }
    private ReturnCar toModel(ReturnCarDto dto){
        ReturnCar model = ReturnCar.builder()
                .id(dto.getId())
                .additionalFees(dto.getAdditionalFees())
                .dateOfReturn(dto.getDateOfReturn())
                .employee(userRepository.getReferenceById(dto.getEmployee()))
                .reservation(reservationsRepository.getReferenceById(dto.getReservationId()))
                .comments(dto.getComments())
                .build();
        return model;
    }


    @Override
    public void returnCar(ReturnCarDto dto) {
        var model = toModel(dto);
        returnCarRepository.save(model);
    }


    public ReturnCar toModel(CreateReturnCarRequest dto){
        ReturnCar model = ReturnCar.builder()
                .id(dto.getId())
                .additionalFees(dto.getAdditionalFees())
                .dateOfReturn(dto.getDateOfReturn())
                .employee(userRepository.getReferenceById(dto.getEmployee()))
                .reservation(reservationsRepository.getReferenceById(dto.getReservationId()))
                .comments(dto.getComments())
                .build();
        return model;
    }

    public ReturnCar toModel(UpdateReturnCarRequest dto){
        ReturnCar model = ReturnCar.builder()
                .id(dto.getId())
                .additionalFees(dto.getAdditionalFees())
                .dateOfReturn(dto.getDateOfReturn())
                .employee(userRepository.getReferenceById(dto.getEmployee()))
                .reservation(reservationsRepository.getReferenceById(dto.getReservationId()))
                .comments(dto.getComments())
                .build();
        return model;
    }

    @Override
    public ReturnCarDto create(CreateReturnCarRequest dto) {
        return toDto(returnCarRepository.save(toModel(dto)));
    }


    @Override
    public ReturnCarDto update(UpdateReturnCarRequest dto) {
        var model = toModel(dto);
        return toDto(returnCarRepository.save(model));
    }

    @Override
    public ReturnCarDto read(long id) {
        return returnCarRepository
                .findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public void delete(long id) {
        returnCarRepository.deleteById(id);
    }


    @Override
    public List<ReturnCarDto> readAll() {
        return returnCarRepository
                .findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


}
