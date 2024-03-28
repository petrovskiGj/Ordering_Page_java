package com.example.finalbmworder.Service.Impl;

import com.example.finalbmworder.Dto.ManufacturerDto;
import com.example.finalbmworder.Mapper.ManufacturerMapper;
import com.example.finalbmworder.Model.Car;
import com.example.finalbmworder.Model.Exceptions.InvalidCarIdException;
import com.example.finalbmworder.Model.Exceptions.InvalidManufacturerIdException;
import com.example.finalbmworder.Model.Manufacturer;
import com.example.finalbmworder.Repository.CarRepository;
import com.example.finalbmworder.Repository.ManufacturerRepository;
import com.example.finalbmworder.Service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerDto> listAllManufacturer() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturers.stream().map(ManufacturerMapper::mapToManufacturerDto).collect(Collectors.toList());
    }

    @Override
    public ManufacturerDto findById(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(InvalidManufacturerIdException::new);
        return ManufacturerMapper.mapToManufacturerDto(manufacturer);
    }

    @Override
    public Manufacturer create(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = ManufacturerMapper.mapToManufacturer(manufacturerDto);
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public void update(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = ManufacturerMapper.mapToManufacturer(manufacturerDto);
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public List<Manufacturer> filterManufacturersByLocation(double minLat, double maxLat, double minLng, double maxLng) {
        return manufacturerRepository.findByLatitudeBetweenAndLongitudeBetween(minLat, maxLat, minLng, maxLng);
    }

    @Override
    public ManufacturerDto findNearestManufacturer(double userLatitude, double userLongitude) {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        Manufacturer nearestManufacturer = manufacturers.stream()
                .min(Comparator.comparingDouble(m -> calculateDistance(userLatitude, userLongitude, m.getLatitude(), m.getLongitude())))
                .orElseThrow(InvalidManufacturerIdException::new);

        return ManufacturerMapper.mapToManufacturerDto(nearestManufacturer);

    }
    // Method to calculate distance between two points using Haversine formula

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth in kilometers

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }


}


