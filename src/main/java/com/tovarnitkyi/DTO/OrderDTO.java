package com.tovarnitkyi.DTO;


import io.swagger.models.auth.In;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private Integer id;
    private String feedback;
    private Integer seller_id;
    private Integer customer_id;
}
