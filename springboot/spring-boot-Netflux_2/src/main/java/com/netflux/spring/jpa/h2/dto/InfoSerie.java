package com.netflux.spring.jpa.h2.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class InfoSerie {
    private String id;
    private String url;
    private String imgURL;
    private String title;
    private String description;
    private Integer yearStart;
    private Integer yearEnd;
    private Integer seasons;

    private String director;
    private Collection<String> creators;

    private Collection<String> cast;

    // Constructor
    public InfoSerie(String id, String url, String imgURL, String title,
            String description, Integer yearStart, Integer yearEnd, Integer seasons,
            Collection<String> creators, Collection<String> cast) {
        this.id = id;
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.seasons = seasons;
        this.creators = creators;
        this.cast = cast;
    }

    // Getters y Setters

}
