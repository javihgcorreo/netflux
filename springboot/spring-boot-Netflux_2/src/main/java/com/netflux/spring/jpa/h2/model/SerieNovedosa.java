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
@Table(name = "seriesnovedades")
public class SerieNovedosa {

    @Id
    @Column(name = "fk_series_id")
    private Long fk_series_id;

    @OneToOne
    @JoinColumn(name = "fk_series_id")
    private Serie series;

    // no se porque aquí si no funciona y en Serie si está puesto.
    // @OneToOne
    // @JoinColumn(name = "fk_series_id")
    // private Serie series;

    public Long getId() {
        return fk_series_id;
    }

}