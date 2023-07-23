package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.mainRental.CreateMainRentalRequest;
import com.example.rentcarapp.models.MainRental;
import com.example.rentcarapp.repositories.AddressRepository;
import com.example.rentcarapp.repositories.MainRentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MainRentalService {

    private final MainRentalRepository mainRentalRepository;
  
    private final AddressRepository addressRepository;

    public MainRentalService(MainRentalRepository mainRentalRepository, AddressRepository addressRepository) {
        this.mainRentalRepository = mainRentalRepository;
        this.addressRepository = addressRepository;
    }

    public List<MainRental> getAllMainRentals() {
        return mainRentalRepository.findAll();
    }

    public Optional<MainRental> getMainRentalsById(Long id) {

    

    public List<com.example.rentcarapp.models.MainRental> getAllMainRentals() {
        return mainRentalRepository.findAll();
    }

    public Optional<com.example.rentcarapp.models.MainRental> getMainRentalsById(Long id) {
        return mainRentalRepository.findById(id);
    }

    public void saveMainRentals(CreateMainRentalRequest dto) {
        mainRentalRepository.save(toModel(dto));
    }

    public void deleteMainRentals(Long id) {
        mainRentalRepository.deleteById(id);
    }

    private MainRental toModel (CreateMainRentalRequest dto){
        return MainRental
                .builder()
                .Name(dto.getName())
                .Contact_Address(addressRepository.getReferenceById(dto.getContact_Address()))
                .Owner(dto.getOwner())
                .Logo(dto.getLogo())
                //.branch_List(dto.getBranch_List())
                .build();
    }

}
