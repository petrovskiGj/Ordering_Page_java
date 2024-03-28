package com.example.finalbmworder.Service;


import com.example.finalbmworder.Dto.EngineDto;
import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Model.Exterior;

import java.util.List;

public interface ExteriorService {
    List<ExteriorDto> listAllExteriors();
    ExteriorDto findById(Long id);
    Exterior create(ExteriorDto exteriorDto);
    void update(ExteriorDto exteriorDto);
    void delete(Long id);
    Exterior markPopular(Long id, ExteriorDto exteriorDto);
    List<ExteriorDto> searchExteriors(String query);

    List<Exterior> filter();
}
