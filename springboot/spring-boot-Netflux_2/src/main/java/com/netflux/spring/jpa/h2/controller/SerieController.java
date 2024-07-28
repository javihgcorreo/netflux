package com.netflux.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.netflux.spring.jpa.h2.model.Serie;
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

    // @GetMapping("/series/hola")
    // public String getSeriesHola() {
    // List<Serie> series = serieRepository.findAll();
    // respuesta = "Series";
    // return respuesta;
    // }

    // @GetMapping("/series/prueba")
    // public List<Serie> getSeries() {
    // if (serieRepository.count() > 0) {
    // // El `SerieRepository` tiene elementos.
    // System.out.println(serieRepository.count() + " <-esto el count");
    // System.out.println(" <-esto el count XXXX");

    // }
    // return serieRepository.findAll();
    // }

    /*
     * @GetMapping("/series")
     * public ResponseEntity<List<Serie>> getAllSeries() {
     * //System.out.println("Paso por aqui");
     * try {
     * List<Serie> series = new ArrayList<Serie>();
     * 
     * //serieRepository.findAll().forEach(series::add);
     * series = serieRepository.findAll();
     * if (series.isEmpty()) {
     * //System.out.println(series.toString());
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * }
     * //System.out.println(series.toString());
     * 
     * return new ResponseEntity<>(series, HttpStatus.OK);
     * } catch (Exception e) {
     * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    @GetMapping("/series")
    public ResponseEntity<List<Serie>> getAllSeries() {
        try {
            List<Serie> series = new ArrayList<Serie>();
            series = serieService.getAllSeries();

            if (series.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/series")
    // public ResponseEntity<List<Serie>> getAllSeries(@RequestParam(required =
    // false) String title) {
    // try {
    // List<Serie> series = new ArrayList<Serie>();

    // if (title == null)
    // serieRepository.findAll().forEach(series::add);
    // else
    // serieRepository.findByTitleContainingIgnoreCase(title).forEach(series::add);
    // // serieRepository.findAll().forEach(series::add);
    // if (series.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<>(series, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @GetMapping("/series/novedades")
    public ResponseEntity<List<Serie>> getAllSeriesNew() {
        try {
            List<Serie> series = new ArrayList<Serie>();

            serieRepository.findByYearendIsNull().forEach(series::add);

            if (series.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<List<Serie>> getSerieById(@PathVariable String id) {
        try {
            List<Serie> series = new ArrayList<Serie>();

            serieRepository.findById(Integer.parseInt(id)).forEach(series::add);

            if (series.size() == 0) {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La serie no existe");
            }

            return new ResponseEntity<>(series, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/series/{id}")
    // public ResponseEntity<Serie> getSerieById(@PathVariable("id") long id)
    // {
    // Optional<Serie> serieData = serieRepository.findById(id);

    // if (serieData.isPresent()) {
    // return new ResponseEntity<>(serieData.get(), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    /*
     * @PostMapping("/series")
     * public ResponseEntity<Serie> createSerie(@RequestBody Serie
     * Serie) {
     * try {
     * Serie _Serie = SerieRepository.save(new
     * Serie(Serie.getTitle(), Serie.getDescription(), false));
     * return new ResponseEntity<>(_Serie, HttpStatus.CREATED);
     * } catch (Exception e) {
     * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

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

    /*
     * @DeleteMapping("/series")
     * public ResponseEntity<HttpStatus> deleteAllSeries() {
     * try {
     * SerieRepository.deleteAll();
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * 
     * }
     */

}
