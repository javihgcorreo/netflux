package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
import java.util.List;

import com.netflux.spring.jpa.h2.dto.InfoPelicula;

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
@Inheritance(strategy = InheritanceType.JOINED)
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pelicula {
    /*
     * @Id
     * 
     * @Column(name = "id")
     * private String id;
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "url", length = 255, nullable = true)
    private String url;

    @Column(name = "img_url", length = 255, nullable = true)
    private String imgURL;

    @Column(name = "title", length = 255, nullable = true)
    private String title;

    @Column(name = "description", length = 255, nullable = true)
    private String description;

    @Column(name = "year_film", nullable = true)
    private Integer yearFilm;

    @Column(name = "duration", nullable = true)
    private Integer duration;

    @Column(name = "director", length = 255, nullable = true)
    private String director;

    // --Relaciones y sus atributos

    @ManyToMany // aqui si es la tabla
    @JoinTable(name = "peliculas_infocasts", joinColumns = @JoinColumn(name = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "infocast_id"))
    private List<Infocast> infocasts_peliculas;

    // @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "fk_peliculasdestacas_id")
    // private PeliculaDestacada peliculasDestacadas;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_peliculasnovedosas_id")
    // private PeliculaNovedosa peliculasNovedades;

    // --Fin relaciones

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
        this.infocasts_peliculas = infocasts;
    }

    public Pelicula(String url, String imgURL, String title, String description,
            Integer yearFilm, Integer duration, String director) {
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.yearFilm = yearFilm;
        this.duration = duration;
        this.director = director;
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
        return this.infocasts_peliculas;
    }

    public void setInfocast(List<Infocast> infocasts) {
        this.infocasts_peliculas = infocasts;
    }

    // otros métodos
    // Otros métodos
    public InfoPelicula toInfoPeliculaSinInfocast() {
        InfoPelicula pelicula = new InfoPelicula();
        pelicula.setId(Long.toString(id));
        pelicula.setUrl(url);
        pelicula.setImgURL(imgURL);
        pelicula.setTitle(title);
        pelicula.setDescription(description);
        pelicula.setYear(yearFilm);
        pelicula.setDuration(duration);
        pelicula.setDirector(director);
        return pelicula;
    }

}
