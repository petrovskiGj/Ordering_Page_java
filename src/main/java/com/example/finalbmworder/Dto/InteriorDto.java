package com.example.finalbmworder.Dto;

import com.example.finalbmworder.Model.Enum.InteriorSeatType;
import com.example.finalbmworder.Model.Enum.InteriorTrimType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InteriorDto {
    @NotEmpty(message = "ID should not be empty")
    private Long id;
    private String photoTrim;
    private String photoSeat;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @Enumerated(EnumType.STRING)
    private InteriorTrimType trimType;
    @Enumerated(EnumType.STRING)
    private InteriorSeatType seatType;
    @NotEmpty(message = "color should not be empty")
    private String colors;
    @NotEmpty(message = "Popularity should not be empty")
    private Integer markPopular;
}
