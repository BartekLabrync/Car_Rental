package com.example.rentcarapp.controllers.rest;

import com.example.rentcarapp.dto.car.CarDto;
import com.example.rentcarapp.dto.car.CreateCarRequest;
import com.example.rentcarapp.dto.car.UpdateCarRequest;
import com.example.rentcarapp.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarRestController {

    private final CarService carService;

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getCarById (@PathVariable long id) {
        CarDto carById = carService.getCarById(id);
        return ResponseEntity.ok(carById);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars () {
        List<CarDto> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar (@RequestBody CreateCarRequest createCarRequest) {
        CarDto carDto = carService.createCar(createCarRequest);
        return ResponseEntity.ok(carDto);
    }



    @PutMapping("{id}")
    public ResponseEntity<CarDto> updateCar (@PathVariable long id, @RequestBody UpdateCarRequest updateCarRequest) {
        carService.updateCar(id, updateCarRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar (@PathVariable long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
