package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.CarDTO;
import com.tovarnitkyi.mapper.CarMapper;
import com.tovarnitkyi.model.Car;
import com.tovarnitkyi.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/car")
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<CarDTO> getAllCar() {
        return carService.getAllCar().stream().map(CarMapper::mapCarToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") Integer id) {
        Car car = carService.getCarById(id);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CarMapper.mapCarToDTO(car), HttpStatus.OK);
    }

    @PostMapping
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        return CarMapper.mapCarToDTO(carService.createCar(carDTO));
    }

    @PutMapping
    public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO) {
        Car car = carService.getCarById(carDTO.getId());
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CarMapper.mapCarToDTO(carService.updateCar(carDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CarDTO> deleteCar(@PathVariable("id") Integer id) {
        Car car = carService.getCarById(id);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CarMapper.mapCarToDTO(carService.deleteCarById(id)), HttpStatus.OK
        );
    }

}
