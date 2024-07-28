package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.PeliculaDestacada;

@Repository
public interface PeliculaDestacadaRepository extends JpaRepository<PeliculaDestacada, Long> {
    // @Query("SELECT p FROM Pelicula p JOIN PeliculasDestacadas pd ON p.id =
    // pd.pelicula_id")
    // List<Pelicula> findPeliculasDestacadas();
    List<PeliculaDestacada> findAll();
}
