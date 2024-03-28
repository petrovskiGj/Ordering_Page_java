package com.example.finalbmworder.Mapper;

import com.example.finalbmworder.Dto.ManufacturerDto;
import com.example.finalbmworder.Model.Manufacturer;

public class ManufacturerMapper {
    public static Manufacturer mapToManufacturer(ManufacturerDto manufacturerDto){
        return Manufacturer.builder()
                .id(manufacturerDto.getId())
                .name(manufacturerDto.getName())
                .country(manufacturerDto.getCountry())
                .city(manufacturerDto.getCity())
                .latitude(manufacturerDto.getLatitude())
                .longitude(manufacturerDto.getLongitude())
                .amountOfCarsProduced(manufacturerDto.getAmountOfCarsProduced())
                .amountOfCarsSold(manufacturerDto.getAmountOfCarsSold())
                .photoUrl(manufacturerDto.getPhotoUrl())
                .siteUrl(manufacturerDto.getSiteUrl())
                .cars(manufacturerDto.getCars())
                .build();
    }
    public static ManufacturerDto mapToManufacturerDto(Manufacturer manufacturer){
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .name(manufacturer.getName())
                .country(manufacturer.getCountry())
                .city(manufacturer.getCity())
                .latitude(manufacturer.getLatitude())
                .longitude(manufacturer.getLongitude())
                .amountOfCarsProduced(manufacturer.getAmountOfCarsProduced())
                .amountOfCarsSold(manufacturer.getAmountOfCarsSold())
                .photoUrl(manufacturer.getPhotoUrl())
                .siteUrl(manufacturer.getSiteUrl())
                .cars(manufacturer.getCars())
                .build();
    }
}
