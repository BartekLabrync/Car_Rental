package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.mainRental.CreateMainRentalRequest;
import com.example.rentcarapp.dto.mainRental.MainRentalDto;
import com.example.rentcarapp.dto.mainRental.UpdateMainRentalRequest;
import com.example.rentcarapp.exception.ReservationNotFoundException;
import com.example.rentcarapp.models.MainRental;
import com.example.rentcarapp.repositories.AddressRepository;
import com.example.rentcarapp.repositories.MainRentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainRentalService {

    private final MainRentalRepository mainRentalRepository;
  
    private final AddressRepository addressRepository;

    public MainRentalService(MainRentalRepository mainRentalRepository, AddressRepository addressRepository) {
        this.mainRentalRepository = mainRentalRepository;
        this.addressRepository = addressRepository;
    }

    public List<MainRentalDto> getAllMainRentals() {
        return mainRentalRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MainRentalDto getMainRentalsById(Long id) {
        return mainRentalRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ReservationNotFoundException("Not found"));
    }

    public MainRentalDto createMainRentals(CreateMainRentalRequest createMainRentalRequest) {
        MainRental mainRental = this.toEntity(createMainRentalRequest);
        mainRental = mainRentalRepository.save(mainRental);
        return this.toDto(mainRental);
    }


    public MainRentalDto updateMainRentals(long id, UpdateMainRentalRequest updateMainRentalRequest) {
        MainRental mainRental = this.toEntity(updateMainRentalRequest);
        mainRental = mainRentalRepository.save(mainRental);
        return this.toDto(mainRental);
    }

    public void deleteMainRentals(Long id) {
        getMainRentalsById(id);
        mainRentalRepository.deleteById(id);
    }

    public MainRentalDto toDto (MainRental mainRental) {
        MainRentalDto dto = new MainRentalDto();
        dto.setId(mainRental.getId());
        dto.setName(mainRental.getName());
        dto.setContact_Address(mainRental.getContact_Address().getId());
        dto.setOwner(mainRental.getOwner());
        dto.setLogo(mainRental.getLogo());
        return dto;
    }

    public MainRental toEntity (MainRentalDto dto) {
        MainRental mainRental = new MainRental();
        mainRental.setId(dto.getId());
        mainRental.setName(dto.getName());
        if(addressRepository.existsById(dto.getContact_Address())){
            mainRental.setContact_Address(addressRepository.getReferenceById(dto.getContact_Address()));
        } else {
            mainRental.setContact_Address(addressRepository.getReferenceById(dto.getContact_Address()));
        }
        mainRental.setOwner(dto.getOwner());
        mainRental.setLogo(dto.getLogo());
        return mainRental;
    }

    public MainRental toEntity (CreateMainRentalRequest dto) {
        MainRental mainRental = new MainRental();
        mainRental.setId(dto.getId());
        mainRental.setName(dto.getName());
        if(addressRepository.existsById(dto.getContact_Address())){
            mainRental.setContact_Address(addressRepository.getReferenceById(dto.getContact_Address()));
        } else {
            mainRental.setContact_Address(addressRepository.getReferenceById(dto.getContact_Address()));
        }
        mainRental.setOwner(dto.getOwner());
        mainRental.setLogo(dto.getLogo());
        return mainRental;
    }

    public MainRental toEntity (UpdateMainRentalRequest dto) {
        MainRental mainRental = new MainRental();
        mainRental.setId(dto.getId());
        mainRental.setName(dto.getName());
        if(addressRepository.existsById(dto.getContact_Address())){
            mainRental.setContact_Address(addressRepository.getReferenceById(dto.getContact_Address()));
        } else {
            mainRental.setContact_Address(addressRepository.getReferenceById(dto.getContact_Address()));
        }
        mainRental.setOwner(dto.getOwner());
        mainRental.setLogo(dto.getLogo());
        return mainRental;
    }

}
