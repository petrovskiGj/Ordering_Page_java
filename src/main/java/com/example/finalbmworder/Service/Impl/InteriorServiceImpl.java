package com.example.finalbmworder.Service.Impl;


import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Dto.InteriorDto;
import com.example.finalbmworder.Model.Exceptions.InvalidExteriorIdException;
import com.example.finalbmworder.Model.Exceptions.InvalidInteriorIdException;
import com.example.finalbmworder.Model.Exterior;
import com.example.finalbmworder.Model.Interior;
import com.example.finalbmworder.Repository.InteriorRepository;
import com.example.finalbmworder.Service.InteriorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.finalbmworder.Mapper.ExteriorMapper.mapToExterior;
import static com.example.finalbmworder.Mapper.InteriorMapper.mapToInterior;
import static com.example.finalbmworder.Mapper.InteriorMapper.mapToInteriorDto;

@Service
public class InteriorServiceImpl implements InteriorService {
    private final InteriorRepository interiorRepository;

    public InteriorServiceImpl(InteriorRepository interiorRepository) {
        this.interiorRepository = interiorRepository;
    }


    @Override
    public List<InteriorDto> listAllInterior() {
        List<Interior> interiors = interiorRepository.findAll();
        return interiors.stream().map(interior -> mapToInteriorDto(interior)).collect(Collectors.toList());
    }

    @Override
    public InteriorDto findById(Long id) {
        Interior interior = interiorRepository.findById(id).orElseThrow(InvalidInteriorIdException::new);
        return mapToInteriorDto(interior);
    }

    @Override
    public Interior create(InteriorDto interiorDto) {
     Interior interior = mapToInterior(interiorDto);
     return interiorRepository.save(interior);
    }

    @Override
    public void update(InteriorDto interiorDto) {
        Interior interior = mapToInterior(interiorDto);
        interiorRepository.save(interior);
    }

    @Override
    public void delete(Long id) {
    interiorRepository.deleteById(id);
    }



    @Override
    public Interior markPopular(Long id, InteriorDto interiorDto) {
        return interiorRepository.findById(id).map(existingInterior->{
            Interior markedInterior= mapToInterior(interiorDto);
            existingInterior.setMarkPopular(markedInterior.getMarkPopular()+1);
            return interiorRepository.save(markedInterior);
        }).orElseThrow(InvalidInteriorIdException::new);
    }
    @Override
    public List<InteriorDto> searchInterior(String query) {
        List<Interior> interiors = interiorRepository.searchInterior(query);
        return interiors.stream().map(interior -> mapToInteriorDto(interior)).collect(Collectors.toList());
    }

    @Override
    public List<Interior> filter() {
        return null;
    }
}
