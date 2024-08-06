package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflux.spring.jpa.h2.repository.TrailerRepository;
import com.netflux.spring.jpa.h2.model.Trailer;
import com.netflux.spring.jpa.h2.dto.TrailerDTO;

import com.netflux.spring.jpa.h2.service.TrailerService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class TrailerService {

    @Autowired
    private TrailerRepository trailerRepository;

    public List<TrailerDTO> getAllTrailers() {

        //
        // Trailers-----------------------------------------------------------------

        List<Trailer> trailers = trailerRepository.findAll();

        // Mapear Trailers a TrailerDTO
        List<TrailerDTO> infoAbreviadasObjects = trailers.stream()
                .map(trailer -> {
                    TrailerDTO infoAbreviada = new TrailerDTO();
                    infoAbreviada.setId(Long.toString(trailer.getId()));
                    infoAbreviada.setUrl(trailer.getUrl());
                    infoAbreviada.setTitle(trailer.getTitle());
                    infoAbreviada.setImgURL(trailer.getImgURL());

                    // ... mapear otros campos
                    return infoAbreviada;
                })
                .collect(Collectors.toList());
        System.out.println("trailerService getAllTrailersNovedosasSalir " + infoAbreviadasObjects);

        return infoAbreviadasObjects;
    }

    public TrailerDTO getTrailerById(Long id) {
        Optional<Trailer> trailerOpcional = trailerRepository.findById(id);// pido la trailer al repositorio de la
                                                                           // BBDD

        Trailer trailer = trailerOpcional.orElse(new Trailer()); // Si está vacío, crea una nueva Trailer, capturo
                                                                 // la Trailer

        // Mapear Trailers a InfoDestacados, uso el constructor del DTO
        TrailerDTO TrailerDTO = new TrailerDTO(
                Long.toString(trailer.getId()), trailer.getTitle(),
                trailer.getUrl(), trailer.getImgURL());

        System.out.println("TrailerDTO = " + TrailerDTO);

        return TrailerDTO;

    }

    public Trailer crear(TrailerDTO trailer) {
        // logger.info(trailer.toString());
        System.out.println("Service:Esto es la trailer = " + (trailer.toString()));
        Trailer nuevaTrailer = trailer.toTrailer();
        System.out.println("Service:Despues de trailerDTO");

        return trailerRepository.save(nuevaTrailer);
    }

    public ResponseEntity<TrailerDTO> actualizar(Long id, TrailerDTO trailerActualizada) {
        try {
            // logger.info(trailer.toString());
            System.out.println("Service:Esto es la trailer = " + (trailerActualizada.toString()));
            // Trailer nuevaTrailer = trailer.toTrailer();

            Optional<Trailer> trailerExistenteOpcional = trailerRepository.findById(id);
            Trailer trailerExistente = trailerExistenteOpcional.orElse(new Trailer()); // Si está vac

            trailerExistente = trailerActualizada.toTrailer();
            trailerExistente.setId(id);

            return new ResponseEntity<>((trailerRepository.save(trailerExistente)).toTrailerDTOSinInfocast(),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public void deleteTrailer(Long id) {
        trailerRepository.deleteById(id);
    }
}