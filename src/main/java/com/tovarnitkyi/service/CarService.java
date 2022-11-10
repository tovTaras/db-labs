package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.CarDTO;
import com.tovarnitkyi.mapper.CarMapper;
import com.tovarnitkyi.model.Car;
import com.tovarnitkyi.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(CarDTO carDTO) {
        return carRepository.save(CarMapper.mapDTOToCar(carDTO));
    }

    public Car updateCar(CarDTO carDTO) {
        if (getCarById(carDTO.getId()) != null) {
            return carRepository.save(CarMapper.mapDTOToCar(carDTO));
        }
        return null;
    }

    public Car deleteCarById(Integer id) {
        Car car = getCarById(id);
        if (car != null) {
            carRepository.deleteById(id);
            return car;
        }
        return null;
    }
}
