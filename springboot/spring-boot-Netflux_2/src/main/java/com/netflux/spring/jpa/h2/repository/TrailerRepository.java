package com.netflux.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.dto.TrailerDTO;
import com.netflux.spring.jpa.h2.model.Trailer;
import com.netflux.spring.jpa.h2.repository.TrailerRepository;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {
    Trailer save(TrailerDTO trailer);

}