package com.tovarnitkyi.mapper;

import com.tovarnitkyi.DTO.OrderDTO;
import com.tovarnitkyi.model.Order;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderMapper {

    public static OrderDTO mapOrderToDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getFeedback(),
                order.getSeller_id(),
                order.getCustomer_id()

        );
    }

    public static Order mapDTOToOrder(OrderDTO orderDTO) {
        return new Order(
                orderDTO.getId(),
                orderDTO.getFeedback(),
                orderDTO.getSeller_id(),
                orderDTO.getCustomer_id()
        );
    }
}