package com.tovarnitkyi.DTO;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car_has_dealershipDTO {
    private Integer id;
    private Integer car_id;
    private Integer dealership_id;
}