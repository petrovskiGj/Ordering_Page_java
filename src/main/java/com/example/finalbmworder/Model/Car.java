package com.example.finalbmworder.Model;

import com.example.finalbmworder.Model.Enum.CarType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "CarTable")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photoUrl;
    private Long price;
    private String color;
    @Column(name = "dateReleased")
    @CreationTimestamp
    private LocalDateTime dateReleased;
    @Enumerated(EnumType.STRING)
    private CarType carTypes;

    @ManyToMany
    @JoinTable(
            name = "Car_Interior",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "interior_id",referencedColumnName = "id")

    )
    private List<Interior> interiors;

    @ManyToMany
    @JoinTable(
            name = "Car_Exterior",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exterior_id", referencedColumnName = "id")
    )
    private List<Exterior> exteriors;

    @ManyToMany
    @JoinTable(
            name = "Car_Engine",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "engine_id", referencedColumnName = "id")
    )
    private List<Engine> engines;

    @ManyToMany
    @JoinTable(
            name = "Car_Manufacturer",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    )
    private List<Manufacturer> manufacturers;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer markPopular = 0;

}


