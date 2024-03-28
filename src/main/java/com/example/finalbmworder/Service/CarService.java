package com.example.finalbmworder.Service;



import com.example.finalbmworder.Dto.CarDto;
import com.example.finalbmworder.Model.Car;
import com.example.finalbmworder.Model.Enum.CarType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CarService {
    List<CarDto> listAllCars();
    CarDto findById(Long id);
    Car create(CarDto carDto);
    void update(CarDto carDto);
    void delete(Long id);
    Car markPopular(Long id,CarDto carDto);
    List<Car> filter(double maxPrice, CarType type, LocalDateTime date, String name);

}
