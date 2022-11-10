package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.Car_has_dealershipDTO;
import com.tovarnitkyi.model.Car_has_dealership;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Car_has_dealershipMapper {

    public static Car_has_dealershipDTO mapCar_has_dealershipToDTO(Car_has_dealership car_has_dealership) {
        return new Car_has_dealershipDTO(
                car_has_dealership.getId(),
                car_has_dealership.getCar_id(),
                car_has_dealership.getDealership_id()
        );
    }

    public static Car_has_dealership mapDTOToCar_has_dealership(Car_has_dealershipDTO car_has_dealershipDTO) {
        return new Car_has_dealership(
                car_has_dealershipDTO.getId(),
                car_has_dealershipDTO.getCar_id(),
                car_has_dealershipDTO.getDealership_id()

        );
    }
}