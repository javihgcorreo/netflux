package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
import com.netflux.spring.jpa.h2.repository.PeliculaDestacadaRepository;
import com.netflux.spring.jpa.h2.repository.PeliculaNovedosaRepository;

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.PeliculaDestacada;
import com.netflux.spring.jpa.h2.model.PeliculaNovedosa;

import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.model.SerieDestacada;
import com.netflux.spring.jpa.h2.dto.InfoDestacados;
import com.netflux.spring.jpa.h2.dto.InfoAbreviada;

import com.netflux.spring.jpa.h2.dto.InfoPelicula;
import com.netflux.spring.jpa.h2.dto.InfocastDTO;
import com.netflux.spring.jpa.h2.dto.PeliculaNewDTO;
import com.netflux.spring.jpa.h2.service.PeliculaService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

// import org.apache.logging.log4j.Logger;
// import org.apache.logging.log4j.LogManager;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaNovedosaRepository peliculaNovedosaRepository;

    // public PeliculaService(PeliculaRepository peliculaRepository) {
    // this.peliculaRepository = peliculaRepository;
    // }

    // public List<InfoPelicula> getAllPeliculas() {
    // // List<Pelicula> peliculas = peliculaRepository.findAll();
    // // return peliculas != null ? peliculas : Collections.emptyList();
    // // System.out.println("llamada peliculaRepository.findAll()");
    // System.err.println("intento realizar un getAllPeliculas en Service");
    // try {
    // List<Pelicula> peliculas;
    // peliculas = peliculaRepository.findAll();

    // return peliculas.stream()
    // .map(peliculas -> new InfoPelicula(
    // peliculas.getId().toString(),
    // peliculas.getUrl(),
    // peliculas.getImgUrl(),
    // peliculas.getTitle(),
    // peliculas.getDescription(),
    // peliculas.getYearFilm(),
    // peliculas.getDuration(),
    // peliculas.getDirector(),
    // peliculas.getInfocasts()))
    // .collect(Collectors.tolist());
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.err.println("intento realizar un getAllPeliculas en Service");
    // return null;
    // }

    // }

    public List<InfoAbreviada> getAllPeliculasNovedosas() {

        // Peliculas
        // Novedades-----------------------------------------------------------------
        List<PeliculaNovedosa> peliculasNovedosas = peliculaNovedosaRepository.findAll();
        List<Long> peliculasNovedosasIds = peliculasNovedosas.stream()
                .map(PeliculaNovedosa::getId)
                .collect(Collectors.toList());
        System.out.println("peliculaService getAllPeliculasNovedosas " + peliculasNovedosas);

        List<Pelicula> peliculasNovedosasFiltradas = peliculaRepository.findAll().stream()
                .filter(pelicula -> peliculasNovedosasIds.contains(pelicula.getId()))
                .collect(Collectors.toList());

        // Mapear Peliculas a InfoAbreviada
        List<InfoAbreviada> infoAbreviadasObjects = peliculasNovedosasFiltradas.stream()
                .map(pelicula -> {
                    InfoAbreviada infoAbreviada = new InfoAbreviada();
                    infoAbreviada.setId(Long.toString(pelicula.getId()));
                    infoAbreviada.setUrl(pelicula.getUrl());
                    infoAbreviada.setTitle(pelicula.getTitle());
                    infoAbreviada.setImgURL(pelicula.getImgUrl());

                    // ... mapear otros campos
                    return infoAbreviada;
                })
                .collect(Collectors.toList());
        System.out.println("peliculaService getAllPeliculasNovedosasSalir " + infoAbreviadasObjects);

        return infoAbreviadasObjects;
    }

    public List<InfoAbreviada> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        if (peliculas == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        // Mapear Peliculas a InfoDestacados
        List<InfoAbreviada> infoDestacadosObjects = peliculas.stream()
                .map(pelicula -> {
                    InfoAbreviada infoAbreviada = new InfoAbreviada();
                    infoAbreviada.setId(Long.toString(pelicula.getId()));
                    infoAbreviada.setUrl(pelicula.getUrl());
                    infoAbreviada.setTitle(pelicula.getTitle());
                    infoAbreviada.setImgURL(pelicula.getImgUrl());

                    // ... mapear otros campos
                    return infoAbreviada;
                })
                .collect(Collectors.toList());

        // Check if infoDestacadosObjects is null
        if (infoDestacadosObjects == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        return infoDestacadosObjects;
    }

    public InfoPelicula getPeliculaById(Long id) {
        Optional<Pelicula> peliculaOpcional = peliculaRepository.findById(id);// pido la pelicula al repositorio de la
                                                                              // BBDD

        Pelicula pelicula = peliculaOpcional.orElse(new Pelicula()); // Si está vacío, crea una nueva Pelicula, capturo
                                                                     // la Pelicula

        Collection<Infocast> casts = pelicula.getInfocast();// de la pelicula saco los actores del cast

        List<InfocastDTO> infoCastsObjects = casts.stream()// mapeo el cast a su DTO
                .map(cast -> new InfocastDTO(cast.getName(), cast.getImgUrl()))
                .collect(Collectors.toList());

        // Mapear Peliculas a InfoDestacados, uso el constructor del DTO

        InfoPelicula infoPelicula = new InfoPelicula(Long.toString(pelicula.getId()), pelicula.getUrl(),
                pelicula.getImgUrl(), pelicula.getTitle(), pelicula.getDescription(), pelicula.getYearFilm(),
                pelicula.getDuration(), pelicula.getDirector(), infoCastsObjects);
        ;

        System.out.println("InfoPelicula = " + infoPelicula);

        return infoPelicula;

        // return peliculaRepository.findById(id).orElse(null);

    }

    // public Pelicula getPeliculaById(Long id) {

    // return peliculaRepository.findById(id).orElse(null);
    // }

    public Pelicula crear(PeliculaNewDTO pelicula) {
        // logger.info(pelicula.toString());
        System.out.println("Service:Esto es la pelicula = " + (pelicula.toString()));
        Pelicula nuevaPelicula = pelicula.toPelicula();
        return peliculaRepository.save(nuevaPelicula);
    }

    public ResponseEntity<InfoPelicula> actualizar(Long id, InfoPelicula peliculaActualizada) {
        try {
            // logger.info(pelicula.toString());
            System.out.println("Service:Esto es la pelicula = " + (peliculaActualizada.toString()));
            // Pelicula nuevaPelicula = pelicula.toPelicula();

            Optional<Pelicula> peliculaExistenteOpcional = peliculaRepository.findById(id);
            Pelicula peliculaExistente = peliculaExistenteOpcional.orElse(new Pelicula()); // Si está vac

            peliculaExistente = peliculaActualizada.toPeliculaSinInfocast();

            return new ResponseEntity<>((peliculaRepository.save(peliculaExistente)).toInfoPeliculaSinInfocast(),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }

}