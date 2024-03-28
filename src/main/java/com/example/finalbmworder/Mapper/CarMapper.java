package com.example.finalbmworder.Mapper;

import com.example.finalbmworder.Dto.CarDto;
import com.example.finalbmworder.Model.Car;

public class CarMapper {
    public static Car mapToCar(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .name(carDto.getName())
                .description(carDto.getDescription())
                .photoUrl(carDto.getPhotoUrl())
                .price(carDto.getPrice())
                .color(carDto.getColor())
                .dateReleased(carDto.getDateReleased())
                .carTypes(carDto.getCarTypes())
                .interiors(carDto.getInteriors())
                .exteriors(carDto.getExteriors())
                .engines(carDto.getEngines())
                .manufacturers(carDto.getManufacturers())
                .user(carDto.getUser())
                .order(carDto.getOrder())
                .build();
    }
    public static CarDto mapToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .name(car.getName())
                .description(car.getDescription())
                .photoUrl(car.getPhotoUrl())
                .price(car.getPrice())
                .color(car.getColor())
                .dateReleased(car.getDateReleased())
                .carTypes(car.getCarTypes())
                .interiors(car.getInteriors())
                .exteriors(car.getExteriors())
                .engines(car.getEngines())
                .manufacturers(car.getManufacturers())
                .user(car.getUser())
                .order(car.getOrder())
                .build();
    }
}
