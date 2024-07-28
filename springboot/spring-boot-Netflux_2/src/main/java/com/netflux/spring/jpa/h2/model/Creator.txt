package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;
//import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;

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
@Table(name = "creators")
public class Creator {
    /*
     * @Id
     * 
     * @Column(name = "id")
     * private String id;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @JoinTable(name = "series_creators", joinColumns = @JoinColumn(name = "creators_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "series_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Serie> series;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "destacado_id")

    // private List<Infocast> cast;

    public Creator(String name) {
        // this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
