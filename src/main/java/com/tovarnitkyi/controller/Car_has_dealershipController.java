package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.Car_has_dealershipDTO;
import com.tovarnitkyi.mapper.Car_has_dealershipMapper;
import com.tovarnitkyi.model.Car_has_dealership;
import com.tovarnitkyi.service.Car_has_dealershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/car_has_dealership")
public class Car_has_dealershipController {
    private final Car_has_dealershipService car_has_dealershipService;

    @GetMapping
    public List<Car_has_dealershipDTO> getAllCar_has_dealership() {
        return car_has_dealershipService.getAllCar_has_dealership().stream().map(Car_has_dealershipMapper::mapCar_has_dealershipToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car_has_dealershipDTO> getCarById(@PathVariable("id") Integer id) {
        Car_has_dealership car_has_dealership = car_has_dealershipService.getCar_has_dealershipById(id);
        if (car_has_dealership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                Car_has_dealershipMapper.mapCar_has_dealershipToDTO(car_has_dealership), HttpStatus.OK);
    }

    @PostMapping
    public Car_has_dealershipDTO createCar_has_dealership(@RequestBody Car_has_dealershipDTO car_has_dealershipDTO) {
        return Car_has_dealershipMapper.mapCar_has_dealershipToDTO(car_has_dealershipService.createCar_has_dealership(car_has_dealershipDTO));
    }

    @PutMapping
    public ResponseEntity<Car_has_dealershipDTO> updateCar(@RequestBody Car_has_dealershipDTO car_has_dealershipDTO) {
        Car_has_dealership car_has_dealership = car_has_dealershipService.getCar_has_dealershipById(car_has_dealershipDTO.getId());
        if (car_has_dealership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                Car_has_dealershipMapper.mapCar_has_dealershipToDTO(car_has_dealershipService.updateCar_has_dealership(car_has_dealershipDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Car_has_dealershipDTO> deleteCar(@PathVariable("id") Integer id) {
        Car_has_dealership car_has_dealership = car_has_dealershipService.getCar_has_dealershipById(id);
        if (car_has_dealership == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                Car_has_dealershipMapper.mapCar_has_dealershipToDTO(car_has_dealershipService.deleteCar_has_dealershipById(id)), HttpStatus.OK
        );
    }

}
