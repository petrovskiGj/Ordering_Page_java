package com.example.finalbmworder.Service;


import com.example.finalbmworder.Dto.EngineDto;
import com.example.finalbmworder.Model.Engine;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.List;

public interface EngineService {
    List<EngineDto> listAllEngines();
    EngineDto findById(Long id);
    Engine create(EngineDto engineDto);
    void update(EngineDto engineDto);
    void delete(Long id);
    Engine markPopular(Long id,EngineDto engineDto);
    List<EngineDto> searchEngines(String query);
    List<Engine> filter();
}
