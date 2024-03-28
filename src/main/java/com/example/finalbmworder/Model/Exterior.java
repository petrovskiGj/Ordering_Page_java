package com.example.finalbmworder.Model;

import com.example.finalbmworder.Model.Enum.ExteriorType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Exterior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;
    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private ExteriorType type;
    private Integer markPopular=0;



}
