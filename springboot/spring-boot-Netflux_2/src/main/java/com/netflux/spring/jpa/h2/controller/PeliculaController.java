package com.netflux.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.time.LocalDate;

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
import org.springframework.http.ResponseEntity;

import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
import com.netflux.spring.jpa.h2.service.PeliculaService;
import com.netflux.spring.jpa.h2.dto.InfoPelicula;
import com.netflux.spring.jpa.h2.dto.InfoAbreviada;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PeliculaController {

    // @Autowired
    // PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaService peliculaService;
    String respuesta;

    // @GetMapping("/peliculas")
    // public ResponseEntity<List<Pelicula>> getAllPeliculas(@RequestParam(required
    // = false) String title) {
    // try {
    // List<Pelicula> peliculas = new ArrayList<Pelicula>();

    // if (title == null)
    // peliculaRepository.findAll().forEach(peliculas::add);
    // else
    // peliculaRepository.findByTitleContainingIgnoreCase(title).forEach(peliculas::add);
    // if (peliculas.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<>(peliculas, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @GetMapping("/peliculas/novedades")
    public ResponseEntity<List<InfoAbreviada>> getAllPeliculasNovedosas() {
        try {
            List<InfoAbreviada> peliculas = new ArrayList<InfoAbreviada>();
            peliculas = peliculaService.getAllPeliculasNovedosas();

            // if (peliculas.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // }

            return new ResponseEntity<>(peliculas, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/peliculas")
    public ResponseEntity<List<InfoAbreviada>> getAllPeliculas() {
        try {
            List<InfoAbreviada> peliculas = new ArrayList<InfoAbreviada>();
            peliculas = peliculaService.getAllPeliculas();

            // if (peliculas.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.OK);
            // }

            return new ResponseEntity<>(peliculas, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/peliculas")
    // public ResponseEntity<List<InfoPelicula>> getAllPeliculas() {
    // try {
    // List<InfoPelicula> peliculas = new ArrayList<InfoPelicula>();
    // peliculas = peliculaService.getAllPeliculas();

    // if (peliculas.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<>(peliculas, HttpStatus.OK);
    // } catch (Exception e) {

    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @GetMapping("/peliculas/novedades")
    // public ResponseEntity<List<Pelicula>> getAllPeliculasNew() {
    // try {
    // List<Pelicula> peliculas = new ArrayList<Pelicula>();

    // // Obtener la fecha actual
    // LocalDate fechaActual = LocalDate.now();

    // // Obtener el año
    // int anio = fechaActual.getYear();

    // peliculaRepository.findByYearFilm(anio).forEach(peliculas::add);

    // if (peliculas.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<>(peliculas, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @GetMapping("/peliculas/{id}")
    // public ResponseEntity<List<Pelicula>> getPeliculasById(@PathVariable String
    // id) {
    // try {
    // List<Pelicula> peliculas = new ArrayList<Pelicula>();

    // peliculaRepository.findById(Integer.parseInt(id)).forEach(peliculas::add);

    // if (peliculas.size() == 0) {

    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La pelicula no
    // existe");
    // }

    // return new ResponseEntity<>(peliculas, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @GetMapping("/peliculas/{id}")
    // public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") long id)
    // {
    // Optional<Pelicula> peliculaData = peliculaRepository.findById(id);

    // if (peliculaData.isPresent()) {
    // return new ResponseEntity<>(peliculaData.get(), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    /*
     * @PostMapping("/peliculas")
     * public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula
     * Pelicula) {
     * try {
     * Pelicula _Pelicula = PeliculaRepository.save(new
     * Pelicula(Pelicula.getTitle(), Pelicula.getDescription(), false));
     * return new ResponseEntity<>(_Pelicula, HttpStatus.CREATED);
     * } catch (Exception e) {
     * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    /*
     * @PutMapping("/peliculas/{id}")
     * public ResponseEntity<Pelicula> updatePelicula(@PathVariable("id") long
     * id, @RequestBody Pelicula Pelicula) {
     * Optional<Pelicula> PeliculaData = PeliculaRepository.findById(id);
     * 
     * if (PeliculaData.isPresent()) {
     * Pelicula _Pelicula = PeliculaData.get();
     * _Pelicula.setTitle(Pelicula.getTitle());
     * _Pelicula.setDescription(Pelicula.getDescription());
     * _Pelicula.setPublished(Pelicula.isPublished());
     * return new ResponseEntity<>(PeliculaRepository.save(_Pelicula),
     * HttpStatus.OK);
     * } else {
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     * }
     */

    /*
     * @DeleteMapping("/peliculas/{id}")
     * public ResponseEntity<HttpStatus> deletePelicula(@PathVariable("id") long id)
     * {
     * try {
     * PeliculaRepository.deleteById(id);
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    /*
     * @DeleteMapping("/peliculas")
     * public ResponseEntity<HttpStatus> deleteAllPeliculas() {
     * try {
     * PeliculaRepository.deleteAll();
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * 
     * }
     */

}
