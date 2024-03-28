package com.example.finalbmworder.Dto;

import com.example.finalbmworder.Model.*;
import com.example.finalbmworder.Model.Enum.CarType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
public class CarDto {
    @NotEmpty(message = "id photo should not be empty")

    private Long id;
    @NotEmpty(message = "name photo should not be empty")

    private String name;
    @NotEmpty(message = "description photo should not be empty")

    private String description;
    @NotEmpty(message = "photo photo should not be empty")

    private String photoUrl;
    @NotEmpty(message = "price photo should not be empty")

    private Long price;
    @NotEmpty(message = "color photo should not be empty")

    private String color;
    @NotEmpty(message = "date photo should not be empty")

    private LocalDateTime dateReleased;
    @NotEmpty(message = "type photo should not be empty")

    private CarType carTypes;
    @NotEmpty(message = "interiors photo should not be empty")

    private List<Interior> interiors;
    @NotEmpty(message = "exteriors photo should not be empty")

    private List<Exterior> exteriors;
    @NotEmpty(message = "engines photo should not be empty")

    private List<Engine> engines;
    @NotEmpty(message = "manufacturers photo should not be empty")

    private List<Manufacturer> manufacturers;
    @NotEmpty(message = "user photo should not be empty")

    private User user;
    @NotEmpty(message = "order photo should not be empty")

    private Order order;
    @NotEmpty(message = "popularity photo should not be empty")

    private Integer markPopular;
}
