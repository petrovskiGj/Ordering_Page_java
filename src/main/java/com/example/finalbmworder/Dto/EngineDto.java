package com.example.finalbmworder.Dto;


import com.example.finalbmworder.Model.Enum.EngineFuelType;
import com.example.finalbmworder.Model.Enum.EngineModelType;
import com.example.finalbmworder.Model.Enum.EngineShifterType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EngineDto {
    private Long id;
    @NotEmpty(message = "Engine photo should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Engine model should not be empty")
    private String name;
    @NotEmpty(message = "Engine horse power should not be empty")
    private double horsePower;
    @NotEmpty(message = "Engine KW should not be empty")
    private double kw;
    private Integer markPopular;
    @NotEmpty(message = "Engine description should not be empty")
    @Size(max = 1000, message = "Engine description cannot exceed 1000 characters")
    private String description;

    @Enumerated(EnumType.STRING)
    private EngineModelType engineType;

    @Enumerated(EnumType.STRING)
    private EngineShifterType engineShifter;

    @Enumerated(EnumType.STRING)
    private EngineFuelType engineFuel;
}
