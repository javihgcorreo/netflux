package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
//import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seriesnovedades") // aunque haya warnig illegal uso dejarlo
@Inheritance(strategy = InheritanceType.JOINED)
// para crearla
public class SerieNovedosa extends Serie {

    // @Id
    // @Column(name = "fk_series_id")
    // private Long fk_series_id;

    // @OneToOne
    // @JoinColumn(name = "fk_series_id")
    // private Serie series;

    // // no se porque aquí si no funciona y en Serie si está puesto.
    // // @OneToOne
    // // @JoinColumn(name = "fk_series_id")
    // // private Serie series;

    // public Long getId() {
    // return fk_series_id;
    // }

}