package com.tovarnitskyi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Car_has_dealership {
    private Integer id;
    private Integer car_id;
    private Integer dealership_id;

    public Car_has_dealership(Integer car_id, Integer dealership_id){
        this(null, car_id, dealership_id);
    }
}
