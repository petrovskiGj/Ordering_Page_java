package com.example.finalbmworder.Service.Impl;



import com.example.finalbmworder.Dto.EngineDto;
import com.example.finalbmworder.Mapper.EngineMapper;
import com.example.finalbmworder.Model.Engine;
import com.example.finalbmworder.Model.Exceptions.InvalidEngineIdException;
import com.example.finalbmworder.Repository.EngineRepository;
import com.example.finalbmworder.Service.EngineService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

import static com.example.finalbmworder.Mapper.EngineMapper.mapToEngine;
import static com.example.finalbmworder.Mapper.EngineMapper.mapToEngineDto;


@Service
public class EngineServiceImpl implements EngineService {
    private final EngineRepository engineRepository;


    public EngineServiceImpl(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public List<EngineDto> listAllEngines() {
        List<Engine>engines = engineRepository.findAll();
        return engines.stream().map((engine) -> mapToEngineDto(engine)).collect(Collectors.toList());
    }

    @Override
    public EngineDto findById(Long id) {
        Engine engine = engineRepository.findById(id).orElseThrow(InvalidEngineIdException::new);
        return mapToEngineDto(engine);
    }

    @Override
    public Engine create(EngineDto engineDto) {
        Engine engine = mapToEngine(engineDto);
        return engineRepository.save(engine);
    }

    @Override
    public void update(EngineDto engineDto) {
        Engine engine = mapToEngine(engineDto);
        engineRepository.save(engine);
    }

    @Override
    public void delete(Long id) {
        engineRepository.deleteById(id);
    }

    @Override
    public Engine markPopular(Long id, EngineDto engineDto) {
        return engineRepository.findById(id).map(existingEngine->{
            Engine markedEngine = mapToEngine(engineDto);
            existingEngine.setMarkPopular(markedEngine.getMarkPopular()+1);
            return engineRepository.save(markedEngine);
        }).orElseThrow(InvalidEngineIdException::new);
    }


    @Override
    public List<EngineDto> searchEngines(String query) {
        List<Engine> engines = engineRepository.searchEngines(query);
        return engines.stream().map(EngineMapper::mapToEngineDto).collect(Collectors.toList());
    }

    @Override
    public List<Engine> filter() {
        return null;
    }
}
