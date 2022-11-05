package com.tovarnitskyi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Characteristics {
    private Integer id;
    private Integer car_id;
    private String serial_number;
    private Boolean is_new;
    private String engine;
    private Integer milage;
    private Integer tank_volume;
    private String color;
    private String maintenance;

    public Characteristics(Integer car_id, String serial_number, Boolean is_new, String engine, Integer milage, Integer tank_volume, String color, String maintenance){
        this(null, car_id, serial_number, is_new, engine, milage, tank_volume, color, maintenance);
    }
}
