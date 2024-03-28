package com.example.finalbmworder.Mapper;

import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Model.Exterior;

public class ExteriorMapper {
    public static Exterior mapToExterior(ExteriorDto exteriorDto){
        return Exterior.builder()
                .id(exteriorDto.getId())
                .photoUrl(exteriorDto.getPhotoUrl())
                .name(exteriorDto.getName())
                .color(exteriorDto.getColor())
                .type(exteriorDto.getType())
                .markPopular(exteriorDto.getMarkPopular())
                .build();

    }
    public static ExteriorDto mapToExteriorDto(Exterior exterior){
        return ExteriorDto.builder()
                .id(exterior.getId())
                .photoUrl(exterior.getPhotoUrl())
                .name(exterior.getName())
                .color(exterior.getColor())
                .type(exterior.getType())
                .markPopular(exterior.getMarkPopular())
                .build();

    }
}
