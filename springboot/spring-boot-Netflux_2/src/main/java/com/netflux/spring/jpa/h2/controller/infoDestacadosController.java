package com.netflux.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.netflux.spring.jpa.h2.dto.InfoDestacados;
import com.netflux.spring.jpa.h2.service.InfoDestacadoService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class infoDestacadosController {

    @Autowired
    InfoDestacadoService infoDestacadaService;

    @GetMapping("/destacados")
    public ResponseEntity<List<InfoDestacados>> getAllDestacados() {
        try {
            List<InfoDestacados> listaInfoDestacados = new ArrayList<InfoDestacados>();
            listaInfoDestacados = infoDestacadaService.getAllDestacados();

            if (listaInfoDestacados.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listaInfoDestacados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
