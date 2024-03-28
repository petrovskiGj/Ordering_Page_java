package com.example.finalbmworder.Service.Impl;



import com.example.finalbmworder.Dto.OrderDto;
import com.example.finalbmworder.Model.Order;
import com.example.finalbmworder.Repository.CarRepository;
import com.example.finalbmworder.Repository.ManufacturerRepository;
import com.example.finalbmworder.Repository.OrderRepository;
import com.example.finalbmworder.Repository.UserRepository;
import com.example.finalbmworder.Service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CarRepository carRepository, ManufacturerRepository manufacturerRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.carRepository = carRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<OrderDto> listAllOrder() {
        return null;
    }

    @Override
    public OrderDto findById(Long id) {
        return null;
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public void update(OrderDto orderDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Order> filter() {
        return null;
    }
}
