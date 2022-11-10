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
@Table(name = "car", schema = "mydb")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "seller_id")
    private Integer seller_id;
    @Column (name = "class_of_car")
    private String class_of_car;
    @Column (name = "brand")
    private String brand;
    @Column (name = "model")
    private String model;
    @Column (name = "is_sold")
    private Boolean is_sold;
}
