package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.car.CarDto;
import com.example.rentcarapp.dto.car.CreateCarRequest;
import com.example.rentcarapp.dto.car.UpdateCarRequest;
import com.example.rentcarapp.models.Car;
import com.example.rentcarapp.repositories.CarRepository;
import com.example.rentcarapp.repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ReservationsRepository reservationsRepository;

    public CarService(CarRepository carRepository, ReservationsRepository reservationsRepository) {
        this.carRepository = carRepository;
        this.reservationsRepository = reservationsRepository;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CarDto getCarById(Long id) {
        return carRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public CarDto createCar (CreateCarRequest createCarRequest) {
        Car car = this.fromConvertToEntity(createCarRequest);
        car = carRepository.save(car);
        return this.convertToDto(car);
    }

    public CarDto updateCar (long id, UpdateCarRequest updateCarRequest) {
        Car car = this.convertToEntity(updateCarRequest);
        car = carRepository.save(car);
        return this.convertToDto(car);
    }

    public void deleteCar(Long id) {
        getCarById(id);
        carRepository.deleteById(id);
    }

    public CarDto convertToDto (Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setName(car.getName());
        dto.setBodyType(car.getBodyType());
        dto.setYear(car.getYear());
        dto.setColor(car.getColor());
        dto.setMileage(car.getMileage());
        //dto.setReservation_id(car.getReservation_id());
        dto.setReservation_id(car.getReservation().getId());
        return dto;
    }

    public Car convertToEntity (CarDto dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setBrand(dto.getBrand());
        car.setName(dto.getName());
        car.setBodyType(dto.getBodyType());
        car.setYear(dto.getYear());
        car.setColor(dto.getColor());
        car.setMileage(dto.getMileage());
        car.setReservation(reservationsRepository.getReferenceById(dto.getReservation_id()));
        return car;
    }

    public Car fromConvertToEntity(CreateCarRequest dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setBrand(dto.getBrand());
        car.setName(dto.getName());
        car.setBodyType(dto.getBodyType());
        car.setYear(dto.getYear());
        car.setColor(dto.getColor());
        car.setMileage(dto.getMileage());
        car.setReservation(reservationsRepository.getReferenceById(dto.getReservation_id()));
        return car;
    }

    public Car convertToEntity (UpdateCarRequest dto) {
        Car car = new Car();
        car.setId(dto.getId());
        car.setBrand(dto.getBrand());
        car.setName(dto.getName());
        car.setBodyType(dto.getBodyType());
        car.setYear(dto.getYear());
        car.setColor(dto.getColor());
        car.setMileage(dto.getMileage());
        car.setReservation(reservationsRepository.getReferenceById(dto.getReservation_id()));
        return car;
    }


}

