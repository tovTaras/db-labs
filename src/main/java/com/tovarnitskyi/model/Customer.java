package com.tovarnitskyi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Customer {
    private Integer id;
    private String first_name;
    private String last_name;
    private String cell_phone;
    private String email;
    public Customer(String first_name, String last_name, String cell_phone, String email){
        this(null,first_name, last_name, cell_phone, email);
    }
}
