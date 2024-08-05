package com.netflux.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.repository.InfocastRepository;

@Repository
public interface InfocastRepository extends JpaRepository<Infocast, Long> {

}