package com.tovarnitkyi.DTO;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CarDTO {
    private Integer id;
    private Integer seller_id;
    private String class_of_car;
    private String brand;
    private String model;
    private Boolean is_sold;
}
