package com.example.finalbmworder.Repository;


import com.example.finalbmworder.Model.Engine;
import com.example.finalbmworder.Model.Interior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InteriorRepository extends JpaRepository<Interior,Long> {
    Optional<Interior> findInteriorByName(String url);

    @Query("SELECT i from Interior i where i.name LIKE CONCAT('%', :query, '%')")
    List<Interior> searchInterior(String query);

}
