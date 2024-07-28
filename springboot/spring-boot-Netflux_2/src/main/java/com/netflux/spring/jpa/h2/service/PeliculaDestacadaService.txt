package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflux.spring.jpa.h2.repository.SerieRepository;
import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
import com.netflux.spring.jpa.h2.repository.PeliculaDestacadaRepository;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.PeliculaDestacada;

import com.netflux.spring.jpa.h2.dto.InfoDestacados;

import java.util.List;
//import java.util.Collection;
import java.util.Collections;

@Service
public class PeliculaDestacadaService {

    @Autowired
    private SerieRepository serieRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaDestacadaRepository peliculaDestacadaRepository;

    private InfoDestacados infoDestacados;

    public List<PeliculaDestacada> getAllDestacados() {
        System.err.println("intento realizar un getAllDestacadas en Service");
        try {
            return peliculaDestacadaRepository.findAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("intento realizar un getAllDestacadas en Service");
        }
        return null;
    }

    // public Destacada getDestacadaById(Long id) {
    // return destacadaRepository.findById(id).orElse(null);
    // }

    // public Destacada saveDestacada(Destacada destacada) {
    // return destacadaRepository.save(destacada);
    // }

    // public void deleteDestacada(Long id) {
    // destacadaRepository.deleteById(id);
    // }
}
