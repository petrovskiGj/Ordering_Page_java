package com.example.finalbmworder.Service;

import com.example.finalbmworder.Dto.OrderDto;
import com.example.finalbmworder.Model.Manufacturer;
import com.example.finalbmworder.Model.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

public interface OrderService {
    List<OrderDto> listAllOrder();
    OrderDto findById(Long id);
    Order create(Order order);
    void update(OrderDto orderDto);
    void delete(Long id);
    List<Order> filter();
}
