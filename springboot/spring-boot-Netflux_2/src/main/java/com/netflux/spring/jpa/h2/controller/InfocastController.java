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

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.repository.InfocastRepository;
import com.netflux.spring.jpa.h2.service.InfocastService;
import com.netflux.spring.jpa.h2.dto.InfocastDTO;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InfocastController {

    // @Autowired
    // InfocastRepository infocastRepository;

    @Autowired
    InfocastService infocastService;
    String respuesta;

    @GetMapping("/infocasts")
    public ResponseEntity<List<InfocastDTO>> getAllInfocasts() {
        try {
            List<InfocastDTO> infocasts = new ArrayList<InfocastDTO>();
            infocasts = infocastService.getAllInfocasts();

            // if (infocasts.isEmpty()) {
            // return new ResponseEntity<>(HttpStatus.OK);
            // }

            return new ResponseEntity<>(infocasts, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/infocasts/{id}")
    public ResponseEntity<InfocastDTO> getInfocastById(@PathVariable("id") long id) {
        try {
            InfocastDTO infocastDTOData = infocastService.getInfocastById(id);
            return new ResponseEntity<>(infocastDTOData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/infocasts")
    public ResponseEntity<Infocast> createInfocast(@RequestBody InfocastDTO infocast_body) {
        try {
            // Infocast _Infocast = InfocastService
            // .save(new Infocast(Infocast.getTitle(), Infocast.getDescription(), false));
            InfocastDTO datosInfocast = new InfocastDTO(
                    infocast_body.getName(),
                    infocast_body.getImgURL());
            // infocast_body.getCast());
            System.out.println("Controller:Esto es la infocast = " + (infocast_body.toString()));
            System.out.println("Controller:infocast procesada = " + (datosInfocast.toString()));

            Infocast _infocast = infocastService.crear(datosInfocast);
            // Infocast _infocast = null;
            return new ResponseEntity<>(_infocast, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/infocasts/{id}")
    public ResponseEntity<InfocastDTO> updateInfocast(@PathVariable("id") long id,
            @RequestBody InfocastDTO infocast_body) {
        try {

            System.out.println("Controller:Esto es la infocast = " + (infocast_body.toString()));
            ResponseEntity<InfocastDTO> _Infocast = infocastService.actualizar(id, infocast_body);
            // Infocast _infocast = null;

            return _Infocast;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/infocasts/{id}")
    public ResponseEntity<HttpStatus> deleteInfocast(@PathVariable("id") long id) {
        try {

            infocastService.deleteInfocast(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
