package com.example.finalbmworder.Model;


import com.example.finalbmworder.Model.Enum.EngineFuelType;
import com.example.finalbmworder.Model.Enum.EngineModelType;
import com.example.finalbmworder.Model.Enum.EngineShifterType;
import jakarta.persistence.*;
import lombok.*;
    @Data
    @Entity
    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public class Engine {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String photoUrl;
        private String name;
        private double horsePower;
        private double kw;
        private Integer markPopular=0;
        @Lob
        @Column(columnDefinition = "TEXT USING description::oid")
        private String description;
        @Enumerated(EnumType.STRING)
        private EngineModelType engineType;

        @Enumerated(EnumType.STRING)
        private EngineShifterType engineShifter;

        @Enumerated(EnumType.STRING)
        private EngineFuelType engineFuel;


    }


