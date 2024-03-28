package com.example.finalbmworder.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "OrderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "OrderedBy", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "OrderedCar", nullable = false)
    private Car car;
    @ManyToOne
    @JoinColumn(name = "ProducedBy", nullable = false)
    private Manufacturer manufacturer;

    public Order(String address, User user, Car car, Manufacturer manufacturer) {
        this.address = address;
        this.user = user;
        this.car = car;
        this.manufacturer = manufacturer;
    }
}
