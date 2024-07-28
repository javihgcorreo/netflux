package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.SerieDestacada;

@Repository
public interface SerieDestacadaRepository extends JpaRepository<SerieDestacada, Long> {
    // List<SerieDestacada> findByPublished(boolean published);

    // @Query("SELECT * FROM SerieDestacada p")
    List<SerieDestacada> findAll();

    // String getSerieDestacadasHola();

    // List<SerieDestacada> findById(long id);

    // List<SerieDestacada> findByTitleContainingIgnoreCase(String title);

    // List<SerieDestacada> findByYearFilm(Integer yearFilm);

    // List<SerieDestacada> findById(Integer id);

    // List<Object> obtenerPeliculasDestacadas();

    // List<Object> getPeliculasDestacadas();
    // List<SerieDestacada> findAllByPeliculasDestacadasIsNotNull();

    // List<SerieDestacada> findAllByPeliculasDestacadasIsNotNull();

    // SerieDestacadasDestacadas getPeliculasDestacadas();

    // String texto = "Lo que devuelvo";

}
