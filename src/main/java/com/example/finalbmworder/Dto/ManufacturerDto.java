package com.example.finalbmworder.Dto;

import com.example.finalbmworder.Model.Car;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ManufacturerDto {
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Country should not be empty")
    private String country;
    @NotEmpty(message = "Country should not be empty")
    private String city;
    @NotEmpty(message = "City should not be empty")
    private double latitude;
    @NotEmpty(message = "Latitude should not be empty")
    private double longitude;
    @NotEmpty(message = "Longitude Produced should not be empty")
    private Integer amountOfCarsProduced;
    @NotEmpty(message = "Cars Sold should not be empty")
    private Integer amountOfCarsSold;
    @NotEmpty(message = "photoUrl Sold should not be empty")
    private String photoUrl;
    @NotEmpty(message = "siteUrl Sold should not be empty")
    private String siteUrl;
    @NotEmpty(message = "Cars should not be empty")
    private List<Car> cars;
}
