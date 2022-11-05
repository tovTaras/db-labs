package com.tovarnitskyi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Car {
    private Integer id;
    private Integer seller_id;
    private String class_of_car;
    private String brand;
    private String model;
    private Boolean is_sold;

    public Car(Integer seller_id, String class_of_car, String brand, String model, Boolean is_sold){
        this(null, seller_id, class_of_car, brand, model, is_sold);
    }
}

