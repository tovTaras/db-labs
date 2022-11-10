package com.tovarnitkyi.DTO;


import io.swagger.models.auth.In;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CharacteristicsDTO {
    private Integer id;
    private Integer car_id;
    private String serial_number;
    private Boolean is_new;
    private String engine;
    private Integer milage;
    private Integer tank_volume;
    private String color;
    private String maintenance;
}
