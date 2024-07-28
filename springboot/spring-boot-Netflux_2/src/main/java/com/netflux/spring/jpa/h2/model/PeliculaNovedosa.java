package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
//import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "peliculasnovedades")
public class PeliculaNovedosa {

    @Id
    @Column(name = "fk_peliculas_id")
    private Long fk_peliculas_id;

    @OneToOne
    @JoinColumn(name = "fk_peliculas_id")
    private Pelicula peliculas;

    // no se porque aquí si no funciona y en Pelicula si está puesto.
    // @OneToOne
    // @JoinColumn(name = "fk_peliculas_id")
    // private Pelicula peliculas;

    public Long getId() {
        return fk_peliculas_id;
    }

}