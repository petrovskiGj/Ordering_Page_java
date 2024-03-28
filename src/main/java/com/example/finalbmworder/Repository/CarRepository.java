package com.example.finalbmworder.Repository;


import com.example.finalbmworder.Dto.CarDto;
import com.example.finalbmworder.Model.Car;
import com.example.finalbmworder.Model.Enum.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
        @Query("SELECT c FROM Car c WHERE c.price < :maxPrice")
        List<Car> findPriceLessThan(@Param("maxPrice") double maxPrice);//1

        List<Car> findByCarTypes(CarType type); //2
        List<Car> findByDateReleasedBefore(LocalDateTime date);//3
        List<Car> findAllByName(String name);//4
        List<Car> findAllByCarTypesAndDateReleasedBefore(CarType type,LocalDateTime date);//2-3
        List<Car> findAllByCarTypesAndName(CarType type,String name);//2-4
        List<Car> findAllByPriceLessThanAndCarTypes(double maxPrice,CarType type);//2-1
        List<Car> findAllByPriceLessThanAndDateReleasedBefore(double maxPrice, LocalDateTime date);//1-3
        List<Car> findAllByPriceLessThanAndName(double maxPrice, String name);//1-4
         List<Car> findAllByDateReleasedBeforeAndName(LocalDateTime date,String name);
         List<Car> findAllByPriceLessThanAndCarTypesAndDateReleasedBefore(double maxPrice,CarType type, LocalDateTime date);//1-2-3
       List<Car> findAllByCarTypesAndDateReleasedBeforeAndName(CarType type,LocalDateTime date,String name);//2-3-4
       List<Car> findAllByPriceLessThanAndDateReleasedBeforeAndName(double maxPrice, LocalDateTime date,String name);//1-3-4
      List<Car> findAllByPriceLessThanAndCarTypesAndName(double maxPrice, CarType type,String name);//1-3-4
      List<Car> findAllByPriceLessThanAndCarTypesAndDateReleasedBeforeAndName(double maxPrice, CarType type, LocalDateTime date, String name);

}








