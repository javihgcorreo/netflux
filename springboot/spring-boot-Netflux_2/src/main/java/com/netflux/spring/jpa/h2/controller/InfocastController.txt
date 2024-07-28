package com.netflux.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
// import java.time.LocalDate;

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

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.repository.InfocastRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InfocastController {

    @Autowired
    InfocastRepository InfocastRepository;

    @GetMapping("/infocasts")
    public ResponseEntity<List<Infocast>> getAllInfocasts(@RequestParam(required = false) String name) {
        try {
            List<Infocast> Infocasts = new ArrayList<Infocast>();

            InfocastRepository.findAll().forEach(Infocasts::add);
            if (Infocasts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(Infocasts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/infocasts2")
    public ResponseEntity<List<Infocast>> getAllInfocasts2(@RequestParam(required = false) String name) {
        try {
            List<Infocast> Infocasts = new ArrayList<Infocast>();

            InfocastRepository.findAll().forEach(Infocasts::add);
            if (Infocasts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(Infocasts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/Infocasts/{id}")
    // public ResponseEntity<List<Infocast>> getInfocastsById(@PathVariable String
    // id) {
    // try {
    // List<Infocast> Infocasts = new ArrayList<Infocast>();

    // InfocastRepository.findById(Integer.parseInt(id)).forEach(Infocasts::add);

    // if (Infocasts.size() == 0) {

    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La Infocast no
    // existe");
    // }

    // return new ResponseEntity<>(Infocasts, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
