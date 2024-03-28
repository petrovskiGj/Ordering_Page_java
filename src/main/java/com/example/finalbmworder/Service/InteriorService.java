package com.example.finalbmworder.Service;


import com.example.finalbmworder.Dto.ExteriorDto;
import com.example.finalbmworder.Dto.InteriorDto;
import com.example.finalbmworder.Model.Exterior;
import com.example.finalbmworder.Model.Interior;

import java.util.List;

public interface InteriorService {
    List<InteriorDto> listAllInterior();
    InteriorDto findById(Long id);
    Interior create(InteriorDto interiorDto);
    void update(InteriorDto interiorDto);
    void delete(Long id);
    Interior markPopular(Long id, InteriorDto interiorDto);
    List<InteriorDto> searchInterior(String query);
    List<Interior> filter();
}
