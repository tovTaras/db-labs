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
@Table(name = "dealership", schema = "mydb")
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "adress")
    private String adress;

}