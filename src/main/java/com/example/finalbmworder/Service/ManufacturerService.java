package com.example.finalbmworder.Service;



import com.example.finalbmworder.Dto.InteriorDto;
import com.example.finalbmworder.Dto.ManufacturerDto;
import com.example.finalbmworder.Model.Interior;
import com.example.finalbmworder.Model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<ManufacturerDto> listAllManufacturer();
    ManufacturerDto findById(Long id);
    Manufacturer create(ManufacturerDto manufacturerDto);
    void update(ManufacturerDto manufacturerDto);
    void delete(Long id);
    List<Manufacturer> filterManufacturersByLocation(double minLat, double maxLat, double minLng, double maxLng);
    ManufacturerDto findNearestManufacturer(double userLatitude, double userLongitude);
}
