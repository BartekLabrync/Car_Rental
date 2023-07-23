package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.reservations.CreateReservationsRequest;
import com.example.rentcarapp.dto.reservations.ReservationDto;
import com.example.rentcarapp.dto.reservations.UpdateReservationsRequest;
import com.example.rentcarapp.models.Reservations;
import com.example.rentcarapp.repositories.BranchRepository;
import com.example.rentcarapp.repositories.RentCarRepository;
import com.example.rentcarapp.repositories.ReservationsRepository;
import com.example.rentcarapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;
    private final UserRepository userRepository;
    private final RentCarRepository rentCarRepository;
    private final BranchRepository branchRepository;


    public List<ReservationDto> getAllReservations() {
        return reservationsRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationsById(Long id) {
        return reservationsRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("not found"));

    }

    public ReservationDto createReservation (CreateReservationsRequest createReservationsRequest) {
        Reservations reservations = this.fromConvertToEntity(createReservationsRequest);
        reservations = reservationsRepository.save(reservations);
        return this.convertToDto(reservations);
    }

    public ReservationDto updateReservation (UpdateReservationsRequest updateReservationsRequest) {
        Reservations reservations = this.convertToEntity(updateReservationsRequest);
        reservations = reservationsRepository.save(reservations);
        return this.convertToDto(reservations);
    }

    public void deleteReservation (Long id) {
        reservationsRepository.deleteById(id);
    }


    public ReservationDto convertToDto (Reservations reservations) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservations.getId());
        dto.setReservDate(reservations.getReservDate());
        dto.setClientId(reservations.getClient().getId());
        dto.setCarId(reservations.getCar().getId());
        dto.setDateFor(reservations.getDateFor());
        dto.setDateTo(reservations.getDateTo());
        dto.setReservBranchId(reservations.getReservBranch().getId());
        dto.setBranchReturnId(reservations.getBranchReturn().getId());
        dto.setAmount(reservations.getAmount());
        dto.setParentId(reservations.getParentId());
        return dto;
    }

    public Reservations convertToEntity (ReservationDto dto) {
        Reservations reservations = new Reservations();
        reservations.setId(dto.getId());
        reservations.setReservDate(dto.getReservDate());
        reservations.setClient(userRepository.getReferenceById(dto.getClientId()));
        reservations.setCar(rentCarRepository.getReferenceById(dto.getCarId()));
        reservations.setDateFor(dto.getDateFor());
        reservations.setDateTo(dto.getDateTo());
        reservations.setReservBranch(branchRepository.getReferenceById(dto.getReservBranchId()));
        reservations.setBranchReturn(branchRepository.getReferenceById(dto.getReservBranchId()));
        reservations.setAmount(dto.getAmount());
        reservations.setParentId(dto.getParentId());
        return reservations;
    }

    public Reservations fromConvertToEntity (CreateReservationsRequest dto) {
        Reservations reservations = new Reservations();
        reservations.setId(dto.getId());
        reservations.setReservDate(dto.getReservDate());
        reservations.setClient(userRepository.getReferenceById(dto.getClientId()));
        reservations.setCar(rentCarRepository.getReferenceById(dto.getCarId()));
        reservations.setDateFor(dto.getDateFor());
        reservations.setDateTo(dto.getDateTo());
        reservations.setReservBranch(branchRepository.getReferenceById(dto.getReservBranchId()));
        reservations.setBranchReturn(branchRepository.getReferenceById(dto.getReservBranchId()));
        reservations.setAmount(dto.getAmount());
        reservations.setParentId(dto.getParentId());
        return reservations;
    }

    public Reservations convertToEntity (UpdateReservationsRequest dto) {
        Reservations reservations = new Reservations();
        reservations.setId(dto.getId());
        reservations.setReservDate(dto.getReservDate());
        reservations.setClient(userRepository.getReferenceById(dto.getClientId()));
        reservations.setCar(rentCarRepository.getReferenceById(dto.getCarId()));
        reservations.setDateFor(dto.getDateFor());
        reservations.setDateTo(dto.getDateTo());
        reservations.setReservBranch(branchRepository.getReferenceById(dto.getReservBranchId()));
        reservations.setBranchReturn(branchRepository.getReferenceById(dto.getReservBranchId()));
        reservations.setAmount(dto.getAmount());
        reservations.setParentId(dto.getParentId());
        return reservations;
    }
}
