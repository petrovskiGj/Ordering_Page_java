package com.example.finalbmworder.Repository;


import com.example.finalbmworder.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
