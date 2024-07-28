package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.Trailer;
import com.netflux.spring.jpa.h2.repository.TrailerRepository;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {
    // List<Trailer> findByPublished(boolean published);

    // @Query("SELECT * FROM Trailer p")
    List<Trailer> findAll();

    // String getTrailersHola();

    // List<Trailer> findById(long id);

    List<Trailer> findByTitleContainingIgnoreCase(String title);
    //List<Trailer> findByYearFilm(Integer yearFilm);
    List<Trailer> findById(Integer id);

    // String texto = "Lo que devuelvo";

}