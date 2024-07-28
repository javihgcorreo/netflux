package com.netflux.spring.jpa.h2.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Pair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflux.spring.jpa.h2.repository.InfocastRepository;
import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
import com.netflux.spring.jpa.h2.repository.PeliculasDestacadasRepository;
import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.model.Pelicula;

@Service
public class ServicioStreamingService {

    @Autowired
    InfocastRepository repoInfocast;
    @Autowired
    PeliculaRepository repoPelicula;
    @Autowired
    PeliculasDestacadasRepository repoPeliculasDestacadas;

    public List<Infocast> obtenerTodosInfocasts() {
        return repoInfocast.findAll();
    }

    public List<Infocast> obtenerPorIdInfocasts(Integer id) {
        return repoInfocast.findById(id);
    }

    public List<Object> obtenerDestacados() {
        List<Object> listaDestacados = new ArrayList<>();

        // repoPelicula.findAllByPeliculasDestacadasIsNotNull();
        // repoSeries.obtenerSeriesDestacadas();
        // listaDestacados.addAll(repoPelicula.findAll());
        listaDestacados.addAll(repoPeliculasDestacadas.findAllByPeliculasDestacadasIsNotNull());

        // falta repoSeries

        return listaDestacados;
    }

    // public Pair<List<Infocast>, List<Pelicula>> obtenerDestacados() {

    // }

}
