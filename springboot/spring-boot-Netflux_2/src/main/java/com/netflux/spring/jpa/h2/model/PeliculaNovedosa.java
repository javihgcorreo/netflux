package com.netflux.spring.jpa.h2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "peliculasnovedades") // aunque haya warnig illegal uso dejarlo para crearla
public class PeliculaNovedosa extends Pelicula {

    // @Id
    // @Column(name = "fk_peliculas_id")
    // private Long fk_peliculas_id;

    // @OneToOne
    // @JoinColumn(name = "fk_peliculas_id")
    // private Pelicula peliculas;

    // // no se porque aquí si no funciona y en Pelicula si está puesto.
    // // @OneToOne
    // // @JoinColumn(name = "fk_peliculas_id")
    // // private Pelicula peliculas;

    // public Long getId() {
    // return fk_peliculas_id;
    // }

}