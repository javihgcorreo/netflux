package com.netflux.spring.jpa.h2.dto;

import java.util.Collection;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
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

    private Collection<InfocastDTO> cast;

    // Constructores
    public InfoSerie() {

    }

    public InfoSerie(String id, String url, String imgURL, String title,
            String description, Integer yearStart, Integer yearEnd, Integer seasons,
            Collection<String> creators, Collection<InfocastDTO> cast) {
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
