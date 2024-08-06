package com.netflux.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.dto.CreatorDTO;
import com.netflux.spring.jpa.h2.model.Creator;
import com.netflux.spring.jpa.h2.repository.CreatorRepository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Long> {
    Creator save(CreatorDTO creator);

}