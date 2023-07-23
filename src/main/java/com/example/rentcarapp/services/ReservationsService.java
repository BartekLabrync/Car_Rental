package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.reservations.CreateReservationsRequest;
import com.example.rentcarapp.dto.reservations.ReservationDto;
import com.example.rentcarapp.dto.reservations.UpdateReservationsRequest;
import com.example.rentcarapp.exception.ReservationNotFoundException;
import com.example.rentcarapp.models.Reservations;
import com.example.rentcarapp.repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public List<ReservationDto> getAllReservations() {
        return reservationsRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationsById(Long id) {
        return reservationsRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ReservationNotFoundException("not found"));

    }

    public ReservationDto createReservation (Reservations reservations) {
        reservations = reservationsRepository.save(reservations);
        return this.convertToDto(reservations);
    }


    public ReservationDto updateReservation (long id, UpdateReservationsRequest updateReservationsRequest) {
        Reservations reservations = this.convertToEntity(updateReservationsRequest);
        reservations = reservationsRepository.save(reservations);
        return this.convertToDto(reservations);
    }

    public void deleteReservation (Long id) {
        getReservationsById(id);
        reservationsRepository.deleteById(id);
    }


    public ReservationDto convertToDto (Reservations reservations) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservations.getId());
        dto.setReservDate(reservations.getReservDate());
        dto.setClientId(reservations.getClientId());
        dto.setCarId(reservations.getCarId());
        dto.setDateFor(reservations.getDateFor());
        dto.setDateTo(reservations.getDateTo());
        dto.setReservBranchId(reservations.getReservBranchId());
        dto.setBranchReturnId(reservations.getBranchReturnId());
        dto.setAmount(reservations.getAmount());
        dto.setParentId(reservations.getParentId());
        return dto;
    }

    public Reservations convertToEntity (ReservationDto dto) {
        Reservations reservations = new Reservations();
        reservations.setId(dto.getId());
        reservations.setReservDate(dto.getReservDate());
        reservations.setClientId(dto.getClientId());
        reservations.setCarId(dto.getCarId());
        reservations.setDateFor(dto.getDateFor());
        reservations.setDateTo(dto.getDateTo());
        reservations.setReservBranchId(dto.getReservBranchId());
        reservations.setBranchReturnId(dto.getBranchReturnId());
        reservations.setAmount(dto.getAmount());
        reservations.setParentId(dto.getParentId());
        return reservations;
    }

    public Reservations fromConvertToEntity (CreateReservationsRequest dto) {
        Reservations reservations = new Reservations();
        reservations.setId(dto.getId());
        reservations.setReservDate(dto.getReservDate());
        reservations.setClientId(dto.getClientId());
        reservations.setCarId(dto.getCarId());
        reservations.setDateFor(dto.getDateFor());
        reservations.setDateTo(dto.getDateTo());
        reservations.setReservBranchId(dto.getReservBranchId());
        reservations.setBranchReturnId(dto.getBranchReturnId());
        reservations.setAmount(dto.getAmount());
        reservations.setParentId(dto.getParentId());
        return reservations;
    }

    public Reservations convertToEntity (UpdateReservationsRequest dto) {
        Reservations reservations = new Reservations();
        reservations.setId(dto.getId());
        reservations.setReservDate(dto.getReservDate());
        reservations.setClientId(dto.getClientId());
        reservations.setCarId(dto.getCarId());
        reservations.setDateFor(dto.getDateFor());
        reservations.setDateTo(dto.getDateTo());
        reservations.setReservBranchId(dto.getReservBranchId());
        reservations.setBranchReturnId(dto.getBranchReturnId());
        reservations.setAmount(dto.getAmount());
        reservations.setParentId(dto.getParentId());
        return reservations;
    }
}
