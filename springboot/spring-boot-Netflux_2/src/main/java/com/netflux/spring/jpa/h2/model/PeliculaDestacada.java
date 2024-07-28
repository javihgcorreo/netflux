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
@Entity
@Table(name = "peliculasdestacadas")
@Getter
@Setter
public class PeliculaDestacada {

    @Id
    @Column(name = "fk_peliculas_id")

    private Long fk_peliculas_id;

    // no se porque aquí si funcion poniendolo y en PeliculaNovedosa me toca
    // comentarlo.
    @OneToOne
    @JoinColumn(name = "fk_peliculas_id")
    private Pelicula peliculas;

    public Long getId() {
        return fk_peliculas_id;
    }

}
