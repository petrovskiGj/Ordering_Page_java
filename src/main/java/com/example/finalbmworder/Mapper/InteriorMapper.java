package com.example.finalbmworder.Mapper;

import com.example.finalbmworder.Dto.InteriorDto;
import com.example.finalbmworder.Model.Interior;

public class InteriorMapper {
    public static Interior mapToInterior(InteriorDto interiorDto){
        return Interior.builder()
                .id(interiorDto.getId())
                .photoTrim(interiorDto.getPhotoTrim())
                .photoSeat(interiorDto.getPhotoSeat())
                .name(interiorDto.getName())
                .seatType(interiorDto.getSeatType())
                .trimType(interiorDto.getTrimType())
                .colors(interiorDto.getColors())
                .markPopular(interiorDto.getMarkPopular())
                .build();
    }
    public static InteriorDto mapToInteriorDto(Interior interior){
        return InteriorDto.builder()
                .id(interior.getId())
                .photoTrim(interior.getPhotoTrim())
                .photoSeat(interior.getPhotoSeat())
                .name(interior.getName())
                .seatType(interior.getSeatType())
                .trimType(interior.getTrimType())
                .colors(interior.getColors())
                .markPopular(interior.getMarkPopular())
                .build();
    }
}
