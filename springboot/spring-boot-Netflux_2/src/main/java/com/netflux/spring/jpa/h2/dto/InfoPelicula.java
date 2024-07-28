package com.netflux.spring.jpa.h2.dto;

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

}
