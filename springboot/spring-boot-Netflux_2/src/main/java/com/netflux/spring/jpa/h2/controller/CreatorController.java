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

import com.netflux.spring.jpa.h2.dto.CreatorDTO;
import com.netflux.spring.jpa.h2.model.Creator;
import com.netflux.spring.jpa.h2.service.CreatorService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CreatorController {

    @Autowired
    CreatorService creatorService;

    @GetMapping("/creators")
    public ResponseEntity<List<CreatorDTO>> getAllCreators() {
        try {
            List<CreatorDTO> creators = new ArrayList<CreatorDTO>();
            creators = creatorService.getAllCreators();

            // if (creators.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.OK);
            // }

            return new ResponseEntity<>(creators, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/creators/{id}")
    public ResponseEntity<CreatorDTO> getCreatorById(@PathVariable("id") long id) {
        try {
            CreatorDTO creatorData = creatorService.getCreatorById(id);
            return new ResponseEntity<>(creatorData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/creators")
    public ResponseEntity<CreatorDTO> createCreator(@RequestBody CreatorDTO creator_body) {
        try {
            System.out.println("Controller:Esto es la creator = " + (creator_body.toString()));

            Creator _creator = creatorService.crear(creator_body);
            // Creator _creator = null;
            return new ResponseEntity<>(_creator.toCreatorDTOSinInfocast(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/creators/{id}")
    public ResponseEntity<CreatorDTO> updateCreator(@PathVariable("id") long id,
            @RequestBody CreatorDTO creator_body) {
        try {

            System.out.println("Controller:Esto es la creator = " + (creator_body.toString()));
            ResponseEntity<CreatorDTO> _Creator = creatorService.actualizar(id, creator_body);
            // Creator _creator = null;
            return _Creator;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/creators/{id}")
    public ResponseEntity<HttpStatus> deleteCreator(@PathVariable("id") long id) {
        try {

            creatorService.deleteCreator(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
