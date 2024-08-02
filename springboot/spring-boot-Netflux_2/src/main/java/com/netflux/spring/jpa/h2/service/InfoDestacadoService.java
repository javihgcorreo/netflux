// package com.netflux.spring.jpa.h2.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.netflux.spring.jpa.h2.repository.SerieRepository;
// import com.netflux.spring.jpa.h2.model.Serie;
// import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
// import com.netflux.spring.jpa.h2.repository.InfoDestacadoRepository;
// import com.netflux.spring.jpa.h2.repository.PeliculaDestacadaRepository;
// import com.netflux.spring.jpa.h2.model.Pelicula;
// import com.netflux.spring.jpa.h2.model.PeliculaDestacada;

// import com.netflux.spring.jpa.h2.dto.InfoDestacados;
// import com.netflux.spring.jpa.h2.dto.InfoPelicula;

// import java.util.List;
// import java.util.stream.Collectors;
// //import java.util.Collection;
// import java.util.Collections;

// @Service
// public class InfoDestacadoService {

//     @Autowired
//     private InfoDestacadoRepository infoDestacadoRepository;

//     private List<InfoDestacados> infoDestacados;

//     public List<InfoDestacados> getAllDestacados() {
//         List<Object[]> infoDestacadosObjects = infoDestacadoRepository.findDestacados();
//         if (infoDestacadosObjects == null) {
//             return Collections.unmodifiableList(Collections.emptyList());
//         }

//         return infoDestacados;
//     }

// }

package com.netflux.spring.jpa.h2.service;

import com.netflux.spring.jpa.h2.dto.InfoDestacados;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.PeliculaDestacada;
import com.netflux.spring.jpa.h2.model.Serie;
import com.netflux.spring.jpa.h2.model.SerieDestacada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflux.spring.jpa.h2.repository.PeliculaDestacadaRepository;
import com.netflux.spring.jpa.h2.repository.PeliculaRepository;
import com.netflux.spring.jpa.h2.repository.SerieDestacadaRepository;
import com.netflux.spring.jpa.h2.repository.SerieRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

@Service
public class InfoDestacadoService {

        @Autowired
        private PeliculaDestacadaRepository peliculaDestacadaRepository;

        @Autowired
        private SerieDestacadaRepository serieDestacadaRepository;

        public List<InfoDestacados> fromListPeliculasToInfoDestacados(List<PeliculaDestacada> peliculas) {
                // // Mapear Peliculas a InfoDestacadas DTO
                List<InfoDestacados> peliculasFiltradas = peliculas.stream()
                                .map(pelicula -> {
                                        InfoDestacados infoDestacado = new InfoDestacados();
                                        infoDestacado.setId(Long.toString(pelicula.getId()));
                                        infoDestacado.setUrl(pelicula.getUrl());
                                        infoDestacado.setType("film");
                                        infoDestacado.setTitle(pelicula.getTitle());
                                        infoDestacado.setImgURL(pelicula.getImgUrl());
                                        // // ... mapear otros campos
                                        return infoDestacado;
                                })
                                .collect(Collectors.toList());

                return peliculasFiltradas;
        }

        public List<InfoDestacados> fromListSeriesToInfoDestacados(List<SerieDestacada> series) {
                // // Mapear Peliculas a InfoDestacadas DTO
                List<InfoDestacados> seriesFiltradas = series.stream()
                                .map(serie -> {
                                        InfoDestacados infoDestacado = new InfoDestacados();
                                        infoDestacado.setId(Long.toString(serie.getId()));
                                        // aqui
                                        infoDestacado.setUrl(serie.getUrl());
                                        infoDestacado.setType("serie");
                                        infoDestacado.setTitle(serie.getTitle());
                                        infoDestacado.setImgURL(serie.getImgURL());
                                        // // ... mapear otros campos
                                        return infoDestacado;
                                })
                                .collect(Collectors.toList());

                return seriesFiltradas;
        }

        public List<InfoDestacados> getAllDestacadas() {
                // return peliculaDestacadaRepository.findAllToInfoDestacados();
                List<PeliculaDestacada> peliculas = peliculaDestacadaRepository.findAll();
                List<SerieDestacada> series = serieDestacadaRepository.findAll();

                List<InfoDestacados> destacados = fromListPeliculasToInfoDestacados(peliculas);
                List<InfoDestacados> destacados2 = fromListSeriesToInfoDestacados(series);
                destacados.addAll(destacados2);

                return destacados;

        }

}
