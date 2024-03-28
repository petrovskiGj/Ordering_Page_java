package com.example.finalbmworder.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String city;
    private double latitude;
    private double longitude;
    private Integer amountOfCarsProduced=0;
    private Integer amountOfCarsSold= 0;
    private String photoUrl;
    private String siteUrl;
//Latitudes are horizontal lines that measure distance north or south of
// the equator. Longitudes are vertical lines that measure east or west
// of the meridian in Greenwich, England

    @ManyToMany
    @JoinTable(
            name = "Manufactory_Car",
            joinColumns = @JoinColumn(name = "manufactory_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "car_id",referencedColumnName = "id")

    )
    private List<Car> cars;
}
