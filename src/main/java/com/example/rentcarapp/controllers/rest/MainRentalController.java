package com.example.rentcarapp.controllers.rest;

import com.example.rentcarapp.dto.mainRental.CreateMainRentalRequest;
import com.example.rentcarapp.dto.mainRental.MainRentalDto;
import com.example.rentcarapp.dto.mainRental.UpdateMainRentalRequest;
import com.example.rentcarapp.models.MainRental;
import com.example.rentcarapp.services.MainRentalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mainRental")
@AllArgsConstructor
public class MainRentalController {

    private final MainRentalService mainRentalService;

    @GetMapping("{id}")
    public ResponseEntity<MainRentalDto> getMainRentalById (@PathVariable long id) {
        MainRentalDto mainRentalById = mainRentalService.getMainRentalsById(id);
        return ResponseEntity.ok(mainRentalById);
    }

    @GetMapping
    public ResponseEntity<List<MainRentalDto>> getAllMainRentals () {
        List<MainRentalDto> mainRental = mainRentalService.getAllMainRentals();
        return ResponseEntity.ok(mainRental);
    }

    @PutMapping("{id}")
    public ResponseEntity<MainRentalDto> updateMainRental (@PathVariable long id, @RequestBody UpdateMainRentalRequest updateMainRentalRequest) {
        mainRentalService.updateMainRentals(id, updateMainRentalRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MainRentalDto> createMainRental (@RequestBody CreateMainRentalRequest createMainRentalRequest) {
        MainRentalDto mainRentalDto = mainRentalService.createMainRentals(createMainRentalRequest);
        return ResponseEntity.ok(mainRentalDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity deleteMainRental (@PathVariable long id) {
        mainRentalService.deleteMainRentals(id);
        return ResponseEntity.ok().build();
    }
}
