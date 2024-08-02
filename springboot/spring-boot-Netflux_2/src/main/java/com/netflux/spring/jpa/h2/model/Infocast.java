package com.netflux.spring.jpa.h2.model;

import java.util.List;

import com.netflux.spring.jpa.h2.dto.InfocastDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "infocast")
public class Infocast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "img_url", length = 255, nullable = false)
    private String imgURL;

    // relaciones- y sus atributos--------------------------

    @ManyToMany(mappedBy = "infocasts_peliculas")
    private List<Pelicula> peliculas_infocasts;

    @JoinTable(name = "series_infocasts", joinColumns = @JoinColumn(name = "infocast_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "series_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Serie> series_infocasts;

    public Infocast() {

    }

    // fin relaciones---------------------------------

    public Infocast(String name, String imgURL) {
        // this.id = id;
        this.name = name;
        this.imgURL = imgURL;
        // this.cast = cast;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgURL;
    }

    public void setImgUrl(String imgURL) {
        this.imgURL = imgURL;
    }

    // otros métodos
    public InfocastDTO toInfocastDTO() {
        return new InfocastDTO(name, imgURL);
    }

}
