package com.netflux.spring.jpa.h2.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class InfoPelicula {
    private String id;
    private String url;
    private String imgURL;
    private String title;
    private String description;
    private Integer year;
    private Integer duration;
    private String director;
    private Collection<String> cast;

    // Constructor
    public InfoPelicula(String id, String url, String imgURL, String title,
            String description, Integer year, Integer duration,
            String director, Collection<String> cast) {
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
