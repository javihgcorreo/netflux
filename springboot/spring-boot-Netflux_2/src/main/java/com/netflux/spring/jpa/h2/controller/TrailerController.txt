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

import com.netflux.spring.jpa.h2.model.Trailer;
import com.netflux.spring.jpa.h2.repository.TrailerRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrailerController {

    @Autowired
    TrailerRepository trailerRepository;
    String respuesta;

    // @GetMapping("/trailers/hola")
    // public String getTrailersHola() {
    // List<Trailer> trailers = trailerRepository.findAll();
    // respuesta = "Trailers";
    // return respuesta;
    // }

    // @GetMapping("/trailers/prueba")
    // public List<Trailer> getTrailers() {
    // if (trailerRepository.count() > 0) {
    // // El `TrailerRepository` tiene elementos.
    // System.out.println(trailerRepository.count() + " <-esto el count");
    // System.out.println(" <-esto el count XXXX");

    // }
    // return trailerRepository.findAll();
    // }

    /*@GetMapping("/trailers")
    public ResponseEntity<List<Trailer>> getAllTrailers() {
        //System.out.println("Paso por aqui"); 
        try {
            List<Trailer> trailers = new ArrayList<Trailer>();

            //trailerRepository.findAll().forEach(trailers::add);
            trailers = trailerRepository.findAll();
            if (trailers.isEmpty()) {
                //System.out.println(trailers.toString());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            //System.out.println(trailers.toString()); 

            return new ResponseEntity<>(trailers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @GetMapping("/trailers")
    public ResponseEntity<List<Trailer>> getAllTrailers(@RequestParam(required
    = false) String title) {
        try {
            List<Trailer> trailers = new ArrayList<Trailer>();

            if (title == null)
                trailerRepository.findAll().forEach(trailers::add);
            else
            trailerRepository.findByTitleContainingIgnoreCase(title).forEach(trailers::add);
            //trailerRepository.findAll().forEach(trailers::add);
            if (trailers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(trailers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/trailers/{id}")
    public ResponseEntity<List<Trailer>> getTrailersById(@PathVariable String id) {
        try {
            List<Trailer> trailers = new ArrayList<Trailer>();

            trailerRepository.findById(Integer.parseInt(id)).forEach(trailers::add);
            
            if (trailers.size() == 0) {
                
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El trailer no existe");
            }
        

        return new ResponseEntity<>(trailers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/trailers/{id}")
    // public ResponseEntity<Trailer> getTrailerById(@PathVariable("id") long id)
    // {
    // Optional<Trailer> trailerData = trailerRepository.findById(id);

    // if (trailerData.isPresent()) {
    // return new ResponseEntity<>(trailerData.get(), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    /*
     * @PostMapping("/trailers")
     * public ResponseEntity<Trailer> createTrailer(@RequestBody Trailer
     * Trailer) {
     * try {
     * Trailer _Trailer = TrailerRepository.save(new
     * Trailer(Trailer.getTitle(), Trailer.getDescription(), false));
     * return new ResponseEntity<>(_Trailer, HttpStatus.CREATED);
     * } catch (Exception e) {
     * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    /*
     * @PutMapping("/trailers/{id}")
     * public ResponseEntity<Trailer> updateTrailer(@PathVariable("id") long
     * id, @RequestBody Trailer Trailer) {
     * Optional<Trailer> TrailerData = TrailerRepository.findById(id);
     * 
     * if (TrailerData.isPresent()) {
     * Trailer _Trailer = TrailerData.get();
     * _Trailer.setTitle(Trailer.getTitle());
     * _Trailer.setDescription(Trailer.getDescription());
     * _Trailer.setPublished(Trailer.isPublished());
     * return new ResponseEntity<>(TrailerRepository.save(_Trailer),
     * HttpStatus.OK);
     * } else {
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     * }
     */

    /*
     * @DeleteMapping("/trailers/{id}")
     * public ResponseEntity<HttpStatus> deleteTrailer(@PathVariable("id") long id)
     * {
     * try {
     * TrailerRepository.deleteById(id);
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    /*
     * @DeleteMapping("/trailers")
     * public ResponseEntity<HttpStatus> deleteAllTrailers() {
     * try {
     * TrailerRepository.deleteAll();
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * 
     * }
     */

}
