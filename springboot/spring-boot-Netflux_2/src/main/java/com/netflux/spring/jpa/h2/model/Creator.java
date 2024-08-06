package com.netflux.spring.jpa.h2.model;

import java.util.List;

import com.netflux.spring.jpa.h2.dto.CreatorDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
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

    @Column(name = "name", length = 255, nullable = true)
    private String name;

    @Column(name = "img_url", length = 255, nullable = true)
    private String imgURL;

    @JoinTable(name = "series_creators", joinColumns = @JoinColumn(name = "creators_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "series_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Serie> series;

    public Creator(String name) {
        // this.id = id;
        this.name = name;
    }

    public Creator(String name, String imgURL, List<Serie> series) {
        this.id = 0L;// me da menos problema a la hora de usarlo para crear o utilizar JPA con H2
        this.name = name;
        this.imgURL = imgURL;
        this.series = series;
    }

    public Creator(String name, String imgURL) {
        this.id = 0L;
        this.name = name;
        this.imgURL = imgURL;
    }

    // Otros métodos
    public CreatorDTO toCreatorDTOSinInfocast() {
        CreatorDTO creator = new CreatorDTO();
        System.out.println("Model:Esto es la creator title = " + name);
        System.out.println("Model:Esto es la creator imgURL = " + imgURL);
        System.out.println("Model:Esto es la creator id.string = " + (Long.toString(id)));

        // creator.setId(Long.toString(id));
        creator.setName(name);
        creator.setImgURL(imgURL);
        System.out.println("Model:Esto es la creator = " + (creator.toString()));

        return creator;
    }

}
