package com.example.rentcarapp.service;

import com.example.rentcarapp.dto.car.CreateCarRequest;
import com.example.rentcarapp.models.Car;
import com.example.rentcarapp.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public void saveCar(CreateCarRequest dto) {
         carRepository.save(toModel(dto));
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private Car toModel (CreateCarRequest dto){
        return Car
                .builder()
                .Brand(dto.getBrand())
                .Name(dto.getName())
                .BodyType(dto.getBodyType())
                .Year(dto.getYear())
                .Color(dto.getColor())
                .Mileage(dto.getMileage())
                .Reservation_id(dto.getReservation_id())
                .build();
    }
}

