package com.example.finalbmworder.Repository;


import com.example.finalbmworder.Model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
    List<Manufacturer> findByLatitudeBetweenAndLongitudeBetween(double minLat, double maxLat, double minLng, double maxLng);


    @Query(value = "SELECT m FROM Manufacturer m ORDER BY FUNCTION('calculate_distance', :userLatitude, :userLongitude, m.latitude, m.longitude)")
        List<Manufacturer> findNearestManufacturers(@Param("userLatitude") double userLatitude, @Param("userLongitude") double userLongitude);


}
