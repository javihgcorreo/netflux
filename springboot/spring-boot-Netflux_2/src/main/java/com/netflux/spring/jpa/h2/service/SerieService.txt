package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflux.spring.jpa.h2.repository.SerieRepository;
import com.netflux.spring.jpa.h2.model.Serie;

import java.util.List;
//import java.util.Collection;
import java.util.Collections;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    // public SerieService(SerieRepository serieRepository) {
    // this.serieRepository = serieRepository;
    // }

    public List<Serie> getAllSeries() {
        // List<Serie> series = serieRepository.findAll();
        // return series != null ? series : Collections.emptyList();
        // System.out.println("llamada serieRepository.findAll()");
        System.err.println("intento realizar un getAllSeries en Service");
        return serieRepository.findAll();
    }

    public Serie getSerieById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public void deleteSerie(Long id) {
        serieRepository.deleteById(id);
    }
}
