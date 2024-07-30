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

    List<Trailer> findAll();

    List<Trailer> findById(long id);

}