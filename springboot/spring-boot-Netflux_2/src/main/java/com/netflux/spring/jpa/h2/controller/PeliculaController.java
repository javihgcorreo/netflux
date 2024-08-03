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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
import com.netflux.spring.jpa.h2.service.PeliculaService;
import com.netflux.spring.jpa.h2.dto.PeliculaNewDTO;

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

    @GetMapping("/peliculas/{id}")
    public ResponseEntity<InfoPelicula> getPeliculaById(@PathVariable("id") long id) {
        try {
            InfoPelicula peliculaData = peliculaService.getPeliculaById(id);
            return new ResponseEntity<>(peliculaData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/peliculas")
    public ResponseEntity<Pelicula> createPelicula(@RequestBody PeliculaNewDTO pelicula_body) {
        try {
            // Pelicula _Pelicula = PeliculaService
            // .save(new Pelicula(Pelicula.getTitle(), Pelicula.getDescription(), false));
            PeliculaNewDTO datosPelicula = new PeliculaNewDTO(
                    pelicula_body.getUrl(),
                    pelicula_body.getImgURL(),
                    pelicula_body.getTitle(),
                    pelicula_body.getDescription(),
                    pelicula_body.getYear(),
                    pelicula_body.getDuration(),
                    pelicula_body.getDirector());
            // pelicula_body.getCast());
            System.out.println("Controller:Esto es la pelicula = " + (pelicula_body.toString()));
            System.out.println("Controller:pelicula procesada = " + (datosPelicula.toString()));

            Pelicula _pelicula = peliculaService.crear(datosPelicula);
            // Pelicula _pelicula = null;
            return new ResponseEntity<>(_pelicula, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PostMapping("/test")
    // public String testForm(UserForm form) {
    // return "Form received";
    // }

    @PutMapping("/peliculas/{id}")
    public ResponseEntity<InfoPelicula> updatePelicula(@PathVariable("id") long id,
            @RequestBody InfoPelicula pelicula_body) {
        try {

            System.out.println("Controller:Esto es la pelicula = " + (pelicula_body.toString()));
            ResponseEntity<InfoPelicula> _infoPelicula = peliculaService.actualizar(id, pelicula_body);
            // Pelicula _pelicula = null;
            return _infoPelicula;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id,
    // @Valid @RequestBody Pelicula peliculaActualizada) {
    // try {
    // Pelicula peliculaActualizada = peliculaService.actualizarPelicula(id,
    // peliculaActualizada);
    // return ResponseEntity.ok(peliculaActualizada);
    // } catch (PeliculaNotFoundException e) {
    // return ResponseEntity.notFound().build();
    // } catch (Exception e) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  

    // }
    // }

    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<HttpStatus> deletePelicula(@PathVariable("id") long id) {
        try {

            peliculaService.deletePelicula(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
