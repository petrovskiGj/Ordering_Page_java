package com.example.finalbmworder.Service.Impl;


import com.example.finalbmworder.Dto.CarDto;
import com.example.finalbmworder.Mapper.CarMapper;
import com.example.finalbmworder.Model.Car;
import com.example.finalbmworder.Model.Engine;
import com.example.finalbmworder.Model.Enum.CarType;
import com.example.finalbmworder.Model.Exceptions.InvalidCarIdException;
import com.example.finalbmworder.Model.Exceptions.InvalidEngineIdException;
import com.example.finalbmworder.Repository.CarRepository;
import com.example.finalbmworder.Service.CarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.finalbmworder.Mapper.CarMapper.mapToCar;
import static com.example.finalbmworder.Mapper.CarMapper.mapToCarDto;
import static com.example.finalbmworder.Mapper.EngineMapper.mapToEngine;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> listAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(CarMapper::mapToCarDto).collect(Collectors.toList());
    }

    @Override
    public CarDto findById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(InvalidCarIdException::new);
        return mapToCarDto(car);
    }

    @Override
    public Car create(CarDto carDto) {
        Car car = mapToCar(carDto);
        return carRepository.save(car);
    }

    @Override
    public void update(CarDto carDto) {
        Car car = mapToCar(carDto);
         carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car markPopular(Long id, CarDto carDto) {
        return carRepository.findById(id).map(existingCar->{
            Car markedCar = mapToCar(carDto);
            existingCar.setMarkPopular(markedCar.getMarkPopular()+1);
            return carRepository.save(markedCar);
        }).orElseThrow(InvalidEngineIdException::new);
    }

    @Override
    public List<Car> filter(double maxPrice, CarType type, LocalDateTime date, String name) {
        if (maxPrice > 0 && type != null && date != null && name != null) {
            return carRepository.findAllByPriceLessThanAndCarTypesAndDateReleasedBeforeAndName(
                    maxPrice, type, date, name);
        } else if (maxPrice > 0 && type != null && date != null) {
            return carRepository.findAllByPriceLessThanAndCarTypesAndDateReleasedBefore(
                    maxPrice, type, date);
        } else if (maxPrice > 0 && type != null && name != null) {
            return carRepository.findAllByPriceLessThanAndCarTypesAndName(
                    maxPrice, type, name);
        } else if (maxPrice > 0 && date != null && name != null) {
            return carRepository.findAllByPriceLessThanAndDateReleasedBeforeAndName(
                    maxPrice, date, name);
        } else if (type != null && date != null && name != null) {
            return carRepository.findAllByCarTypesAndDateReleasedBeforeAndName(
                    type, date, name);
        } else if (maxPrice > 0 && type != null) {
            return carRepository.findAllByPriceLessThanAndCarTypes(
                    maxPrice, type);
        } else if (maxPrice > 0 && date != null) {
            return carRepository.findAllByPriceLessThanAndDateReleasedBefore(
                    maxPrice, date);
        } else if (maxPrice > 0 && name != null) {
            return carRepository.findAllByPriceLessThanAndName(
                    maxPrice, name);
        } else if (type != null && date != null) {
            return carRepository.findAllByCarTypesAndDateReleasedBefore(
                    type, date);
        } else if (type != null && name != null) {
            return carRepository.findAllByCarTypesAndName(
                    type, name);
        } else if (date != null && name != null) {
            return carRepository.findAllByDateReleasedBeforeAndName(
                    date, name);
        } else if (maxPrice > 0) {
            return carRepository.findPriceLessThan(
                    maxPrice);
        } else if (type != null) {
            return carRepository.findByCarTypes(
                    type);
        } else if (date != null) {
            return carRepository.findByDateReleasedBefore(
                    date);
        } else if (name != null) {
            return carRepository.findAllByName(
                    name);
        } else {
            return carRepository.findAll();
        }

    }


}
