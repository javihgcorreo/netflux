package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflux.spring.jpa.h2.repository.SerieNovedosaRepository;
import com.netflux.spring.jpa.h2.repository.SerieRepository;
import com.netflux.spring.jpa.h2.dto.InfoAbreviada;
import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.model.SerieNovedosa;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.Collection;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;
    @Autowired
    private SerieNovedosaRepository serieNovedosaRepository;

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

    public List<InfoAbreviada> getAllSeriesNovedosas() {

        // Series
        // Novedades-----------------------------------------------------------------
        List<SerieNovedosa> seriesNovedosas = serieNovedosaRepository.findAll();
        List<Long> seriesNovedosasIds = seriesNovedosas.stream()
                .map(SerieNovedosa::getId)
                .collect(Collectors.toList());
        System.out.println("serieService getAllSeriesNovedosas " + seriesNovedosas);

        List<Serie> seriesNovedosasFiltradas = serieRepository.findAll().stream()
                .filter(serie -> seriesNovedosasIds.contains(serie.getId()))
                .collect(Collectors.toList());

        // Mapear Series a InfoAbreviada
        List<InfoAbreviada> infoAbreviadasObjects = seriesNovedosasFiltradas.stream()
                .map(serie -> {
                    InfoAbreviada infoAbreviada = new InfoAbreviada();
                    infoAbreviada.setId(Long.toString(serie.getId()));
                    infoAbreviada.setUrl(serie.getUrl());
                    infoAbreviada.setTitle(serie.getTitle());
                    infoAbreviada.setImgURL(serie.getImgURL());

                    // ... mapear otros campos
                    return infoAbreviada;
                })
                .collect(Collectors.toList());
        System.out.println("serieService getAllSeriesNovedosasSalir " + infoAbreviadasObjects);

        return infoAbreviadasObjects;
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
