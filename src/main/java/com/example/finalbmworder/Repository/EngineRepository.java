package com.example.finalbmworder.Repository;


import com.example.finalbmworder.Model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EngineRepository extends JpaRepository<Engine,Long> {
    Optional<Engine> findEngineByName(String url);

    @Query("SELECT e from Engine e where e.name LIKE CONCAT('%', :query, '%')")
    List<Engine> searchEngines(String query);



}
