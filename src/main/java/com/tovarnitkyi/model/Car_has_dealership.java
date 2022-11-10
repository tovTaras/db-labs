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
@Table(name = "car_has_dealership", schema = "mydb")
public class Car_has_dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "seller_id")
    private Integer car_id;
    @Column (name = "dealership_id")
    private Integer dealership_id;

}
