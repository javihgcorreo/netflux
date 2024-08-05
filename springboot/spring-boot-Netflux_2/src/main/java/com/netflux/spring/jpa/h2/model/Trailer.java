package com.netflux.spring.jpa.h2.model;

import com.netflux.spring.jpa.h2.dto.TrailerDTO;

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
@Table(name = "trailers")
public class Trailer {
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

    @Column(name = "title", length = 255, nullable = true)
    private String title;

    @Column(name = "url", length = 255, nullable = true)
    private String url;

    @Column(name = "img_url", length = 255, nullable = true)
    private String imgURL;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "trailer_id")

    // private List<InfoCast> cast;

    public Trailer(String title, String url, String imgURL) {
        this.title = title;
        this.url = url;
        this.imgURL = imgURL;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    // Constructores
    public Trailer(String id, String title, String url, String imgURL) {
        this.id = Long.parseLong(id);
        this.title = title;
        this.url = url;
        this.imgURL = imgURL;
    }

    // Otros métodos
    public TrailerDTO toTrailerDTOSinInfocast() {
        TrailerDTO trailer = new TrailerDTO();
        System.out.println("Model:Esto es la trailer id = " + id);
        System.out.println("Model:Esto es la trailer title = " + title);
        System.out.println("Model:Esto es la trailer url = " + url);
        System.out.println("Model:Esto es la trailer imgURL = " + imgURL);
        System.out.println("Model:Esto es la trailer id.string = " + (Long.toString(id)));

        trailer.setId(Long.toString(id));
        trailer.setTitle(title);
        trailer.setUrl(url);
        trailer.setImgURL(imgURL);
        System.out.println("Model:Esto es la trailer = " + (trailer.toString()));

        return trailer;
    }

}
