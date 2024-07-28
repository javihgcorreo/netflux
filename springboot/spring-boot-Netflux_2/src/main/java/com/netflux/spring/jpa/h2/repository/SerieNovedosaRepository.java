package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.netflux.spring.jpa.h2.model.SerieNovedosa;

@Repository
public interface SerieNovedosaRepository extends JpaRepository<SerieNovedosa, Long> {
    // @Query("SELECT p FROM Serie p JOIN SeriesDestacadas pd ON p.id =
    // pd.serie_id")
    // List<Serie> findSeriesDestacadas();
    List<SerieNovedosa> findAll();
}
