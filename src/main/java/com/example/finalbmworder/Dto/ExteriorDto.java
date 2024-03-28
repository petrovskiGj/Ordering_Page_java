package com.example.finalbmworder.Dto;

import com.example.finalbmworder.Model.Enum.ExteriorType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExteriorDto {

        private Long id;
        private String photoUrl;
         @NotEmpty(message = "Name should not be empty")
        private String name;
         @NotEmpty(message = "Color should not be empty")
        private String color;
         @NotEmpty(message = "Type should not be empty")
        private ExteriorType type;
        private Integer markPopular;


    }


