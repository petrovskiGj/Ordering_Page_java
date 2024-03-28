package com.example.finalbmworder.Repository;

import com.example.finalbmworder.Model.Engine;
import com.example.finalbmworder.Model.Exterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExteriorRepository extends JpaRepository<Exterior,Long> {
    Optional<Exterior> findExteriorByName(String url);

    @Query("SELECT e from Exterior e where e.name LIKE CONCAT('%', :query, '%')")
    List<Exterior> searchExterior(String query);
}
