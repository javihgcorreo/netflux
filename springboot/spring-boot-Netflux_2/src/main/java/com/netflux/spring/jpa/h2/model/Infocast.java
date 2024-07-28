package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
//import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;

@Entity
@Table(name = "infocast")
public class Infocast {
    /*
     * @Id
     * 
     * @Column(name = "id")
     * private String id;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "img_url", length = 255, nullable = false)
    private String imgURL;

    @JoinTable(name = "peliculas_infocast", joinColumns = @JoinColumn(name = "infocast_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "peliculas_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Pelicula> peliculas;

    @JoinTable(name = "series_infocast", joinColumns = @JoinColumn(name = "infocast_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "series_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Serie> series;

    public Infocast() {

    }

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

    // public obtenerActoresTodos() {
    // <List>Infocast actores;
    // return <List> Infocast actores;
    // }

    // @Override
    // public String toString() {
    // return "Infocast{" +
    // "id='" + id + '\'' +
    // ", title='" + name + '\'' +
    // ", imgURL='" + imgURL + '\'' +
    // ", peliculas=" + peliculas +
    // '}';
    // }

    // @Override
    // public String toString() {

    // return "Infocast [id=" + id + ", url=" + url + ", description=" + description
    // + ", year=" + yearFilm
    // + ", duration=" + duration + ", director=" + director + "]";

    // }

}
