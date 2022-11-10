package com.tovarnitkyi.controller;

import com.tovarnitkyi.DTO.OrderDTO;
import com.tovarnitkyi.mapper.OrderMapper;
import com.tovarnitkyi.model.Order;
import com.tovarnitkyi.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrder() {
        return orderService.getAllOrder().stream().map(OrderMapper::mapOrderToDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Integer id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                OrderMapper.mapOrderToDTO(order), HttpStatus.OK);
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return OrderMapper.mapOrderToDTO(orderService.createOrder(orderDTO));
    }

    @PutMapping
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.getOrderById(orderDTO.getId());
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                OrderMapper.mapOrderToDTO(orderService.updateOrder(orderDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("id") Integer id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                OrderMapper.mapOrderToDTO(orderService.deleteOrderById(id)), HttpStatus.OK
        );
    }

}