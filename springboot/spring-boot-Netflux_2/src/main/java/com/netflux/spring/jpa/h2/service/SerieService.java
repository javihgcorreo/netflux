package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflux.spring.jpa.h2.repository.SerieNovedosaRepository;
import com.netflux.spring.jpa.h2.repository.SerieRepository;
import com.netflux.spring.jpa.h2.dto.InfoAbreviada;
import com.netflux.spring.jpa.h2.dto.InfoPelicula;
import com.netflux.spring.jpa.h2.dto.InfoSerie;
import com.netflux.spring.jpa.h2.dto.InfocastDTO;
import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.model.SerieNovedosa;
import com.netflux.spring.jpa.h2.model.Creator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    public List<InfoSerie> getAllSeries() {
        List<Serie> series = serieRepository.findAll();// pido todas las series
        if (series == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        // Mapear Series a InfoDestacados
        List<InfoSerie> infoSeriesObjects = series.stream()
                .map(serie -> {
                    InfoSerie infoSerie = new InfoSerie(
                            Long.toString(serie.getId()),
                            serie.getUrl(),
                            serie.getImgURL(),
                            serie.getTitle(),
                            serie.getDescription(),
                            serie.getYearStart(),
                            serie.getYearEnd(),
                            serie.getSeasons(),
                            null,
                            null
                    // serie.getCreators(),
                    // serie.getInfocast()
                    );

                    // ... mapear otros campos
                    return infoSerie;
                })
                .collect(Collectors.toList());

        // Check if infoDestacadosObjects is null
        if (infoSeriesObjects == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        return infoSeriesObjects;
    }

    // public List<Serie> getAllSeries() {
    // // List<Serie> series = serieRepository.findAll();
    // // return series != null ? series : Collections.emptyList();
    // // System.out.println("llamada serieRepository.findAll()");
    // System.err.println("intento realizar un getAllSeries en Service");
    // return serieRepository.findAll();
    // }

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

    public InfoSerie getSerieById(Long id) {
        Optional<Serie> serieOpcional = serieRepository.findById(id);// pido la serie al repositorio de la
                                                                     // BBDD

        Serie serie = serieOpcional.orElse(new Serie()); // Si está vacío, crea una nueva Serie, capturo
                                                         // la Serie

        Collection<Infocast> casts = serie.getInfocast();// de la serie saco los actores del cast

        List<InfocastDTO> infoCastsObjects = casts.stream()// mapeo el cast a su DTO
                .map(cast -> new InfocastDTO(cast.getName(), cast.getImgUrl()))
                .collect(Collectors.toList());

        Collection<Creator> creators = serie.getCreators();// de la serie saco los actores del cast

        List<String> creatorsObjects = creators.stream()// mapeo el cast a su DTO
                .map(creator -> new String(creator.getName()))
                .collect(Collectors.toList());

        // Mapear Series a InfoDestacados, uso el constructor del DTO

        InfoSerie infoSerie = new InfoSerie(Long.toString(serie.getId()), serie.getUrl(),
                serie.getImgURL(), serie.getTitle(), serie.getDescription(), serie.getYearStart(), serie.getYearEnd(),
                serie.getSeasons(), creatorsObjects, infoCastsObjects);
        ;

        System.out.println("InfoSerie = " + infoSerie);

        return infoSerie;

        // return serieRepository.findById(id).orElse(null);

    }

    // public Serie getSerieById(Long id) {
    // return serieRepository.findById(id).orElse(null);
    // }

    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public void deleteSerie(Long id) {
        serieRepository.deleteById(id);
    }
}
