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
    private PeliculaRepository peliculaRepository;

    @Autowired
    private SerieDestacadaRepository serieDestacadaRepository;
    @Autowired
    private SerieRepository serieRepository;

    public List<InfoDestacados> getAllDestacados() {

        // Peliculas
        // destacadas-----------------------------------------------------------------
        List<PeliculaDestacada> peliculasDestacadas = peliculaDestacadaRepository.findAll();
        List<Long> peliculasDestacadasIds = peliculasDestacadas.stream()
                .map(PeliculaDestacada::getId)
                .collect(Collectors.toList());

        List<Pelicula> peliculasDestacadasFiltradas = peliculaRepository.findAll().stream()
                .filter(pelicula -> peliculasDestacadasIds.contains(pelicula.getId()))
                .collect(Collectors.toList());

        // Series
        // destacadas-----------------------------------------------------------------
        List<SerieDestacada> seriesDestacadas = serieDestacadaRepository.findAll();
        List<Long> seriesDestacadasIds = seriesDestacadas.stream()
                .map(SerieDestacada::getId)
                .collect(Collectors.toList());

        List<Serie> seriesDestacadasFiltradas = serieRepository.findAll().stream()
                .filter(Serie -> seriesDestacadasIds.contains(Serie.getId()))
                .collect(Collectors.toList());

        // Mapear Peliculas a InfoDestacados
        List<InfoDestacados> infoDestacadosObjects = peliculasDestacadasFiltradas.stream()
                .map(pelicula -> {
                    InfoDestacados infoDestacado = new InfoDestacados();
                    infoDestacado.setId(Long.toString(pelicula.getId()));
                    infoDestacado.setUrl(pelicula.getUrl());
                    infoDestacado.setType("film");
                    infoDestacado.setTitle(pelicula.getTitle());
                    infoDestacado.setImgURL(pelicula.getImgUrl());

                    // ... mapear otros campos
                    return infoDestacado;
                })
                .collect(Collectors.toList());

        // Mapear Series a InfoDestacados
        List<InfoDestacados> infoDestacadosObjects2 = seriesDestacadasFiltradas.stream()
                .map(serie -> {
                    InfoDestacados infoDestacado = new InfoDestacados();
                    infoDestacado.setId(Long.toString(serie.getId()));
                    infoDestacado.setUrl(serie.getUrl());
                    infoDestacado.setType("serie");
                    infoDestacado.setTitle(serie.getTitle());
                    infoDestacado.setImgURL(serie.getImgUrl());

                    // ... mapear otros campos
                    return infoDestacado;
                })
                .collect(Collectors.toList());

        // concatenar Peliculas y series
        infoDestacadosObjects.addAll(infoDestacadosObjects2);

        // Check if infoDestacadosObjects is null
        if (infoDestacadosObjects == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        return infoDestacadosObjects;
    }
}
