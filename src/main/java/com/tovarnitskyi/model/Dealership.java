package com.tovarnitskyi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Dealership {
    private Integer id;
    private  String adress;

    public Dealership(String adress){
        this(null, adress);
    }
}
