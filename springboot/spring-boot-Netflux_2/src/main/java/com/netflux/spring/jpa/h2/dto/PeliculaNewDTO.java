package com.netflux.spring.jpa.h2.dto;

import java.util.Collection;
import java.util.List;

import com.netflux.spring.jpa.h2.model.Pelicula;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class PeliculaNewDTO {
    private String url;
    private String imgURL;
    private String title;
    private String description;
    private Integer year;
    private Integer duration;
    private String director;
    private Collection<InfocastDTO> cast;

    // Constructor
    public PeliculaNewDTO() {

    }

    public PeliculaNewDTO(String url, String imgURL, String title,
            String description, Integer year, Integer duration,
            String director, Collection<InfocastDTO> cast) {
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.year = year;
        this.duration = duration;
        this.director = director;
        this.cast = cast;
    }

    public PeliculaNewDTO(String url, String imgURL, String title,
            String description, Integer year, Integer duration,
            String director) {
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.year = year;
        this.duration = duration;
        this.director = director;
    }

    // Getters y Setters

    public Pelicula toPelicula() {
        Pelicula nueva = new Pelicula(
                this.url,
                this.imgURL,
                this.title,
                this.description,
                this.year,
                this.duration,
                this.director);
        return nueva;
    }

}