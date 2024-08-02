package com.netflux.spring.jpa.h2.dto;

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.model.Pelicula;

import java.util.Collection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class InfoPelicula {
    private String id;
    private String url;
    private String imgURL;
    private String title;
    private String description;
    private Integer year;
    private Integer duration;
    private String director;
    private Collection<InfocastDTO> cast;

    // Constructor

    public InfoPelicula() {
    }

    public InfoPelicula(String id, String url, String imgURL, String title,
            String description, Integer year, Integer duration,
            String director, Collection<InfocastDTO> cast) {
        this.id = id;
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.year = year;
        this.duration = duration;
        this.director = director;
        this.cast = cast;
    }

    // Getters y Setters

    // Otros métodos
    public Pelicula toPeliculaSinInfocast() {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(Long.parseLong(id));
        pelicula.setUrl(url);
        pelicula.setImgUrl(imgURL);
        pelicula.setTitle(title);
        pelicula.setDescription(description);
        pelicula.setYearFilm(year);
        pelicula.setDuration(duration);
        pelicula.setDirector(director);
        return pelicula;
    }

}
