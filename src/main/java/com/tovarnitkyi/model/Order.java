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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "seller_id")
    private Integer seller_id;
    @Column(name = "customer_id")
    private Integer customer_id;
}