package com.tovarnitkyi.model;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@ToString
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "characteristics", schema = "mydb")
public class Characteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "car_id")
    private Integer car_id;
    @Column (name = "serial_number")
    private String serial_number;
    @Column (name = "is_new")
    private Boolean is_new;
    @Column (name = "engine")
    private String engine;
    @Column (name = "milage")
    private Integer milage;
    @Column (name = "tank_volume")
    private Integer tank_volume;
    @Column (name = "color")
    private String color;
    @Column (name = "maintenance")
    private String maintenance;

}