package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "peliculas")
public class Pelicula {
    /*
     * @Id
     * 
     * @Column(name = "id")
     * private String id;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "url", length = 255, nullable = false)
    private String url;

    @Column(name = "img_url", length = 255, nullable = false)
    private String imgURL;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "year_film", nullable = false)
    private Integer yearFilm;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "director", length = 255, nullable = false)
    private String director;

    @ManyToMany(mappedBy = "peliculas")
    private List<Infocast> infocasts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_peliculasdestacas_id")
    private PeliculaDestacada peliculasDestacadas;

    // @OneToOne(mappedBy = "peliculas", cascade = CascadeType.ALL)
    // private PeliculaDestacada peliculasDestacadas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_peliculasnovedosas_id")
    private PeliculaNovedosa peliculasNovedades;

    // @OneToOne
    // @JoinColumn(name = "fk_peliculas_id")
    // private PeliculasDestacadas peliculasDestacadas;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "pelicula_id")

    // private List<InfoCast> cast;

    public Pelicula(String url, String imgURL, String title, String description,
            Integer yearFilm, Integer duration, String director, List<Infocast> infocasts) {
        // this.id = id;
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.yearFilm = yearFilm;
        this.duration = duration;
        this.director = director;
        this.infocasts = infocasts;
    }

    public long getId() {
        return id;
    }

    public String getIdString() {
        return Long.toString(id);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgURL;
    }

    public void setImgUrl(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearFilm() {
        return yearFilm;
    }

    public void setYearFilm(Integer yearFilm) {
        this.yearFilm = yearFilm;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Infocast> getInfocast() {
        return this.infocasts;
    }

    public void setInfocast(List<Infocast> infocasts) {
        this.infocasts = infocasts;
    }

}
