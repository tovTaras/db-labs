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
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "cell_phone")
    private String cell_phone;
    @Column(name = "email")
    private String email;
    @Column(name = "adress")
    private String adress;
}