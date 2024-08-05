package com.netflux.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.netflux.spring.jpa.h2.dto.InfoAbreviada;
import com.netflux.spring.jpa.h2.dto.InfoPelicula;
import com.netflux.spring.jpa.h2.dto.InfoSerie;
import com.netflux.spring.jpa.h2.dto.PeliculaNewDTO;
import com.netflux.spring.jpa.h2.dto.SerieNewDTO;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.repository.SerieRepository;
import com.netflux.spring.jpa.h2.service.SerieService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SerieController {

    @Autowired
    SerieRepository serieRepository;

    @Autowired
    SerieService serieService;

    String respuesta;

    @GetMapping("/series")
    public ResponseEntity<List<InfoSerie>> getAllSeries() {
        try {
            List<InfoSerie> series = new ArrayList<InfoSerie>();
            series = serieService.getAllSeries();

            // if (series.isEmpty()) {
            // InfoSerie serie = new InfoSerie();
            // serie.setUrl("No hay series");
            // series.add(serie);
            // return new ResponseEntity<>(series, HttpStatus.OK);
            // }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (

        Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/series/novedades")
    public ResponseEntity<List<InfoAbreviada>> getAllSeriesNovedosas() {
        try {
            List<InfoAbreviada> series = new ArrayList<InfoAbreviada>();
            series = serieService.getAllSeriesNovedosas();

            // if (series.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/series/novedades2")
    public ResponseEntity<List<InfoAbreviada>> getAllSeriesNovedosas2() {
        try {
            List<InfoAbreviada> series = new ArrayList<InfoAbreviada>();
            series = serieService.getAllSeriesNovedosas2();

            // if (series.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<InfoSerie> getSerieById(@PathVariable("id") long id) {
        try {
            InfoSerie serieData = serieService.getSerieById(id);
            return new ResponseEntity<>(serieData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/series")
    public ResponseEntity<Serie> createSerie(@RequestBody SerieNewDTO serie_body) {
        try {
            // Serie _Serie = SerieService
            // .save(new Serie(Serie.getTitle(), Serie.getDescription(), false));
            SerieNewDTO datosSerie = new SerieNewDTO(
                    serie_body.getUrl(),
                    serie_body.getImgURL(),
                    serie_body.getTitle(),
                    serie_body.getDescription(),
                    serie_body.getYearStart(),
                    serie_body.getYearEnd(),
                    serie_body.getSeasons());
            // serie_body.getCast());
            System.out.println("Controller:Esto es la serie = " + (serie_body.toString()));
            System.out.println("Controller:serie procesada = " + (datosSerie.toString()));

            Serie _serie = serieService.crear(datosSerie);
            // Serie _serie = null;
            return new ResponseEntity<>(_serie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/series/{id}")
    public void deleteSerie(@PathVariable("id") long id) {
        serieRepository.deleteById(id);
    }

    @PutMapping("/series/{id}")
    public ResponseEntity<InfoSerie> updateSerie(@PathVariable("id") long id,
            @RequestBody InfoSerie serie_body) {
        try {

            System.out.println("Controller:Esto es la serie = " + (serie_body.toString()));
            ResponseEntity<InfoSerie> _infoSerie = serieService.actualizar(id, serie_body);
            // Serie _serie = null;
            return _infoSerie;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * @PutMapping("/series/{id}")
     * public ResponseEntity<Serie> updateSerie(@PathVariable("id") long
     * id, @RequestBody Serie Serie) {
     * Optional<Serie> SerieData = SerieRepository.findById(id);
     * 
     * if (SerieData.isPresent()) {
     * Serie _Serie = SerieData.get();
     * _Serie.setTitle(Serie.getTitle());
     * _Serie.setDescription(Serie.getDescription());
     * _Serie.setPublished(Serie.isPublished());
     * return new ResponseEntity<>(SerieRepository.save(_Serie),
     * HttpStatus.OK);
     * } else {
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     * }
     */

    /*
     * @DeleteMapping("/series/{id}")
     * public ResponseEntity<HttpStatus> deleteSerie(@PathVariable("id") long id)
     * {
     * try {
     * SerieRepository.deleteById(id);
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

}
