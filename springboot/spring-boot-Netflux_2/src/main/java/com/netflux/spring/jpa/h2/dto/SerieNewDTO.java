package com.netflux.spring.jpa.h2.dto;

import java.util.Collection;
import java.util.List;

import com.netflux.spring.jpa.h2.model.Serie;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class SerieNewDTO {
    private String url;
    private String imgURL;
    private String title;
    private String description;
    private Integer yearStart;
    private Integer yearEnd;
    private Integer seasons;
    private Collection<String> creators;
    private Collection<InfocastDTO> cast;

    // Constructor
    public SerieNewDTO() {

    }

    public SerieNewDTO(String url, String imgURL, String title,
            String description, Integer yearStart, Integer yearEnd, Integer seasons,
            Collection<String> creators, Collection<InfocastDTO> cast) {
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

    public SerieNewDTO(String url, String imgURL, String title,
            String description, Integer yearStart, Integer yearEnd, Integer seasons) {
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.seasons = seasons;
    }

    // Getters y Setters

    public Serie toSerie() {
        Serie nueva = new Serie(
                this.url,
                this.imgURL,
                this.title,
                this.description,
                this.yearStart,
                this.yearEnd,
                this.seasons);
        return nueva;
    }

}