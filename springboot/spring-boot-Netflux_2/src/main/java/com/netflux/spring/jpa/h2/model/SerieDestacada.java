package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
//import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "seriesdestacadas")
public class SerieDestacada {

    @Id
    @Column(name = "fk_series_id")
    // @Column(name = "fk_series_id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // este fk_series es la clave ajena y principal, hacia peliculsa
    private Long fk_series_id;

    @OneToOne
    @JoinColumn(name = "fk_series_id")
    private Serie series;

    public Long getId() {
        return fk_series_id;
    }

}
