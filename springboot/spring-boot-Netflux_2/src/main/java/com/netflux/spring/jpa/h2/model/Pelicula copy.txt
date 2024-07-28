package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
import java.util.List;

//import org.hibernate.mapping.List;

//import com.netflux.spring.jpa.h2.model.PeliculasDestacadas;

import jakarta.persistence.*;

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

    @OneToOne(mappedBy = "peliculas", cascade = CascadeType.ALL)
    private PeliculasDestacadas peliculasDestacadas;

    // @OneToOne
    // @JoinColumn(name = "fk_peliculas_id")
    // private PeliculasDestacadas peliculasDestacadas;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "pelicula_id")

    // private List<InfoCast> cast;

    public Pelicula() {

    }

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

    public List<Infocast> getInfocast() {
        return this.infocasts;
    }

    public void setInfocast(List<Infocast> infocasts) {
        this.infocasts = infocasts;
    }

    // public PeliculasDestacadas getPeliculasDestacadas() {
    // PeliculasDestacadas peliD = new PeliculasDestacadas();
    // return peliD/* this.peliculasDestacadas */;
    // }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year_film=" + yearFilm +
                ", duration=" + duration +
                ", director='" + director + '\'' +
                ", cast1=" + infocasts +
                '}';
    }// este metodo no lo realiza muestro otro que no es este

    // @Override
    // public String toString() {

    // return "Pelicula [id=" + id + ", url=" + url + ", description=" + description
    // + ", year=" + yearFilm
    // + ", duration=" + duration + ", director=" + director + "]";

    // }

}
