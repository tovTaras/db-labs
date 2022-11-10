package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.CarDTO;
import com.tovarnitkyi.model.Car;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CarMapper {

    public static CarDTO mapCarToDTO(Car car) {
        return new CarDTO(
                car.getId(),
                car.getSeller_id(),
                car.getClass_of_car(),
                car.getBrand(),
                car.getModel(),
                car.getIs_sold()
        );
    }

    public static Car mapDTOToCar(CarDTO carDTO) {
        return new Car(
                carDTO.getId(),
                carDTO.getSeller_id(),
                carDTO.getClass_of_car(),
                carDTO.getBrand(),
                carDTO.getModel(),
                carDTO.getIs_sold()
        );
    }
}
