package com.example.finalbmworder.Mapper;


import com.example.finalbmworder.Dto.EngineDto;
import com.example.finalbmworder.Model.Engine;

public class EngineMapper {


    public static Engine mapToEngine(EngineDto engine) {
        return Engine.builder()
                .id(engine.getId())
                .photoUrl(engine.getPhotoUrl())
                .name(engine.getName())
                .horsePower(engine.getHorsePower())
                .kw(engine.getKw())
                .markPopular(engine.getMarkPopular())
                .description(engine.getDescription())
                .engineType(engine.getEngineType())
                .engineShifter(engine.getEngineShifter())
                .engineFuel(engine.getEngineFuel())
                .build();
    }

    public static EngineDto mapToEngineDto(Engine engine) {
        return EngineDto.builder()
                .id(engine.getId())
                .photoUrl(engine.getPhotoUrl())
                .name(engine.getName())
                .horsePower(engine.getHorsePower())
                .kw(engine.getKw())
                .markPopular(engine.getMarkPopular())
                .description(engine.getDescription())
                .engineType(engine.getEngineType())
                .engineShifter(engine.getEngineShifter())
                .engineFuel(engine.getEngineFuel())
                .build();
    }

}
