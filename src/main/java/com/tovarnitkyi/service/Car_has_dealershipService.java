package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.Car_has_dealershipDTO;
import com.tovarnitkyi.mapper.Car_has_dealershipMapper;
import com.tovarnitkyi.model.Car_has_dealership;
import com.tovarnitkyi.repository.Car_has_dealershipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class Car_has_dealershipService {

    private final Car_has_dealershipRepository car_has_dealershipRepository;

    public List<Car_has_dealership> getAllCar_has_dealership() {
        return car_has_dealershipRepository.findAll();
    }

    public Car_has_dealership getCar_has_dealershipById(Integer id) {
        return car_has_dealershipRepository.findById(id).orElse(null);
    }

    public Car_has_dealership createCar_has_dealership(Car_has_dealershipDTO car_has_dealershipDTO) {
        return car_has_dealershipRepository.save(Car_has_dealershipMapper.mapDTOToCar_has_dealership(car_has_dealershipDTO));
    }

    public Car_has_dealership updateCar_has_dealership(Car_has_dealershipDTO car_has_dealershipDTO) {
        if (getCar_has_dealershipById(car_has_dealershipDTO.getId()) != null) {
            return car_has_dealershipRepository.save(Car_has_dealershipMapper.mapDTOToCar_has_dealership(car_has_dealershipDTO));
        }
        return null;
    }

    public Car_has_dealership deleteCar_has_dealershipById(Integer id) {
        Car_has_dealership car_has_dealership = getCar_has_dealershipById(id);
        if (car_has_dealership != null) {
            car_has_dealershipRepository.deleteById(id);
            return car_has_dealership;
        }
        return null;
    }
}