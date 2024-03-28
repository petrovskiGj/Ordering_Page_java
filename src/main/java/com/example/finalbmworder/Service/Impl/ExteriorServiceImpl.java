package com.example.finalbmworder.Service.Impl;


import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Mapper.EngineMapper;
import com.example.finalbmworder.Model.Engine;
import com.example.finalbmworder.Model.Exceptions.InvalidEngineIdException;
import com.example.finalbmworder.Model.Exceptions.InvalidExteriorIdException;
import com.example.finalbmworder.Model.Exterior;
import com.example.finalbmworder.Repository.ExteriorRepository;
import com.example.finalbmworder.Service.ExteriorService;
import org.springframework.stereotype.Service;
import com.example.finalbmworder.Mapper.ExteriorMapper;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.finalbmworder.Mapper.EngineMapper.mapToEngine;
import static com.example.finalbmworder.Mapper.ExteriorMapper.mapToExterior;
import static com.example.finalbmworder.Mapper.ExteriorMapper.mapToExteriorDto;

@Service
public class ExteriorServiceImpl implements ExteriorService {
    private final ExteriorRepository exteriorRepository;

    public ExteriorServiceImpl(ExteriorRepository exteriorRepository) {
        this.exteriorRepository = exteriorRepository;
    }


    @Override
    public List<ExteriorDto> listAllExteriors() {
        List<Exterior> exteriors = exteriorRepository.findAll();
        return exteriors.stream().map(ExteriorMapper::mapToExteriorDto).collect(Collectors.toList());
    }

    @Override
    public ExteriorDto findById(Long id) {
        Exterior exterior = exteriorRepository.findById(id).orElseThrow(InvalidExteriorIdException::new);
        return mapToExteriorDto(exterior);
    }

    @Override
    public Exterior create(ExteriorDto exteriorDto) {
       Exterior exterior = mapToExterior(exteriorDto);
       return exteriorRepository.save(exterior);
    }

    @Override
    public void update(ExteriorDto exteriorDto) {
        Exterior exterior = mapToExterior(exteriorDto);
       exteriorRepository.save(exterior);
    }

    @Override
    public void delete(Long id) {
        exteriorRepository.deleteById(id);
    }

    @Override
    public Exterior markPopular(Long id, ExteriorDto exteriorDto) {
        return exteriorRepository.findById(id).map(existingExterior->{
            Exterior markedExterior= mapToExterior(exteriorDto);
            existingExterior.setMarkPopular(markedExterior.getMarkPopular()+1);
            return exteriorRepository.save(markedExterior);
        }).orElseThrow(InvalidExteriorIdException::new);
    }

    @Override
    public List<ExteriorDto> searchExteriors(String query) {
        List<Exterior> engines = exteriorRepository.searchExterior(query);
        return engines.stream().map(ExteriorMapper::mapToExteriorDto).collect(Collectors.toList());
    }

    @Override
    public List<Exterior> filter() {
        return null;
    }
}
