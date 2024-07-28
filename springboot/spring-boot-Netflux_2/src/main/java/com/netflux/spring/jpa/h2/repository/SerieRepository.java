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
    // List<Serie> findAll();

    // String texto = "Lo que devuelvo";

}