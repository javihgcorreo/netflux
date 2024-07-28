package com.netflux.spring.jpa.h2.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "creators")
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @JoinTable(name = "series_creators", joinColumns = @JoinColumn(name = "creators_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "series_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Serie> series;

    public Creator(String name) {
        // this.id = id;
        this.name = name;
    }

    public Creator(String name, List<Serie> series) {
        // this.id = id;
        this.name = name;
        this.series = series;
    }

}
