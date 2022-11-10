package com.tovarnitkyi.DTO;


import io.swagger.models.auth.In;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private String cell_phone;
    private String email;
}
