package com.tovarnitkyi.service;

import com.tovarnitkyi.DTO.OrderDTO;
import com.tovarnitkyi.mapper.OrderMapper;
import com.tovarnitkyi.model.Order;
import com.tovarnitkyi.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(OrderDTO orderDTO) {
        return orderRepository.save(OrderMapper.mapDTOToOrder(orderDTO));
    }

    public Order updateOrder(OrderDTO orderDTO) {
        if (getOrderById(orderDTO.getId()) != null) {
            return orderRepository.save(OrderMapper.mapDTOToOrder(orderDTO));
        }
        return null;
    }

    public Order deleteOrderById(Integer id) {
        Order order = getOrderById(id);
        if (order != null) {
            orderRepository.deleteById(id);
            return order;
        }
        return null;
    }
}