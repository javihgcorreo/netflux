package com.netflux.spring.jpa.h2.repository;

import com.netflux.spring.jpa.h2.dto.PeliculaNewDTO;

import java.util.List;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // List<Pelicula> findByPublished(boolean published);

    // @Query("SELECT * FROM Pelicula p")

    // List<Pelicula> findAll();
    // peliculas != null ? peliculas : Collections.emptyList();
    List<Pelicula> findAll();

    Pelicula findById(long id);

    Pelicula save(PeliculaNewDTO pelicula);

}