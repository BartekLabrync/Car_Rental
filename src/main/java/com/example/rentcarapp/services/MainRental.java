package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.mainRental.CreateMainRentalRequest;
import com.example.rentcarapp.repositories.MainRentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainRental {

    private final MainRentalRepository mainRentalRepository;

    public MainRental(MainRentalRepository mainRentalRepository) {
        this.mainRentalRepository = mainRentalRepository;
    }

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

    private com.example.rentcarapp.models.MainRental toModel (CreateMainRentalRequest dto){
        return com.example.rentcarapp.models.MainRental
                .builder()
                .Name(dto.getName())
                .Contact_Address(dto.getContact_Address())
                .Owner(dto.getOwner())
                .Logo(dto.getLogo())
                .Branch_List(dto.getBranch_List())
                .build();
    }

}
