package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.repository.SerieRepository;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    // List<Serie> findByPublished(boolean published);

    // @Query("SELECT * FROM Serie p")
    List<Serie> findAll();

    // String getSeriesHola();

    // List<Serie> findById(long id);

    List<Serie> findByTitleContainingIgnoreCase(String title);

    List<Serie> findByYearendIsNull();

    List<Serie> findById(Integer id);

    // String texto = "Lo que devuelvo";

}