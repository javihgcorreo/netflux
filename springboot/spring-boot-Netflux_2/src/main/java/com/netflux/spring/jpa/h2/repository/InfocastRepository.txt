package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.repository.InfocastRepository;

@Repository
public interface InfocastRepository extends JpaRepository<Infocast, Long> {
    // List<Infocast> findByPublished(boolean published);

    // @Query("SELECT * FROM Infocast p")
    List<Infocast> findAll();

    // List<Infocast> getAllInfocasts();

    // String getInfocastsHola();

    // List<Infocast> findById(long id);

    // List<Infocast> findByNameContainingIgnoreCase(String name);

    // List<Infocast> findByYearFilm(Integer yearFilm);
    List<Infocast> findById(Integer id);

    // List<Infocast> findByPeliculas_infocastContainingIgnoreCase(long
    // peliculas_infocast);

    // String texto = "Lo que devuelvo";

}