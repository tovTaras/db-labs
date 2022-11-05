package com.tovarnitskyi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Order {
    private Integer id;
    private String feedback;
    private Integer seller_id;
    private Integer customer_id;

    public Order(String feedback, Integer seller_id, Integer customer_id){
        this(null, feedback, seller_id, customer_id);
    }
}
