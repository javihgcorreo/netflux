package com.netflux.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
//import java.time.LocalDate;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.netflux.spring.jpa.h2.dto.TrailerDTO;
import com.netflux.spring.jpa.h2.model.Trailer;
import com.netflux.spring.jpa.h2.service.TrailerService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrailerController {

    @Autowired
    TrailerService trailerService;

    @GetMapping("/trailers")
    public ResponseEntity<List<TrailerDTO>> getAllTrailers() {
        try {
            List<TrailerDTO> trailers = new ArrayList<TrailerDTO>();
            trailers = trailerService.getAllTrailers();

            // if (trailers.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.OK);
            // }

            return new ResponseEntity<>(trailers, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/trailers/{id}")
    public ResponseEntity<TrailerDTO> getTrailerById(@PathVariable("id") long id) {
        try {
            TrailerDTO trailerData = trailerService.getTrailerById(id);
            return new ResponseEntity<>(trailerData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/trailers")
    public ResponseEntity<TrailerDTO> createTrailer(@RequestBody TrailerDTO trailer_body) {
        try {
            System.out.println("Controller:Esto es la trailer = " + (trailer_body.toString()));

            Trailer _trailer = trailerService.crear(trailer_body);
            // Trailer _trailer = null;
            return new ResponseEntity<>(_trailer.toTrailerDTOSinInfocast(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/trailers/{id}")
    public ResponseEntity<TrailerDTO> updateTrailer(@PathVariable("id") long id,
            @RequestBody TrailerDTO trailer_body) {
        try {

            System.out.println("Controller:Esto es la trailer = " + (trailer_body.toString()));
            ResponseEntity<TrailerDTO> _Trailer = trailerService.actualizar(id, trailer_body);
            // Trailer _trailer = null;
            return _Trailer;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/trailers/{id}")
    public ResponseEntity<HttpStatus> deleteTrailer(@PathVariable("id") long id) {
        try {

            trailerService.deleteTrailer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
