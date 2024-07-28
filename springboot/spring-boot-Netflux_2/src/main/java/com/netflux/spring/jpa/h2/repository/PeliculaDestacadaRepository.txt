package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.PeliculaDestacada;

@Repository
public interface PeliculaDestacadaRepository extends JpaRepository<PeliculaDestacada, Long> {
    // List<PeliculaDestacada> findByPublished(boolean published);

    // @Query("SELECT * FROM PeliculaDestacada p")
    List<PeliculaDestacada> findAll();

    // String getPeliculaDestacadasHola();

    // List<PeliculaDestacada> findById(long id);

    // List<PeliculaDestacada> findByTitleContainingIgnoreCase(String title);

    // List<PeliculaDestacada> findByYearFilm(Integer yearFilm);

    // List<PeliculaDestacada> findById(Integer id);

    // List<Object> obtenerPeliculasDestacadas();

    // List<Object> getPeliculasDestacadas();
    // List<PeliculaDestacada> findAllByPeliculasDestacadasIsNotNull();

    // List<PeliculaDestacada> findAllByPeliculasDestacadasIsNotNull();

    // PeliculaDestacadasDestacadas getPeliculasDestacadas();

    // String texto = "Lo que devuelvo";

}
