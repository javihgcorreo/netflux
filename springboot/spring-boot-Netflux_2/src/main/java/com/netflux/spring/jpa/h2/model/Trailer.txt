package com.netflux.spring.jpa.h2.model;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "url", length = 255, nullable = false)
    private String url;

    @Column(name = "img_url", length = 255, nullable = false)
    private String imgURL;


    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "trailer_id")

    // private List<InfoCast> cast;

    public Trailer() {

    }

    public Trailer(String title, String url, String imgURL) {
        // this.id = id;
        this.title = title;
        this.url = url;
        this.imgURL = imgURL;
        // this.cast = cast;
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

    public String getImgUrl() {
        return imgURL;
    }

    public void setImgUrl(String imgURL) {
        this.imgURL = imgURL;
    }


    @Override
    public String toString() {
        return "Trailer{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", imgURL='" + imgURL + '\'' +
                // ", cast=" + cast +
                '}';
    }

    // @Override
    // public String toString() {

    // return "Trailer [id=" + id + ", url=" + url + ", description=" + description
    // + ", year=" + yearFilm
    // + ", duration=" + duration + ", director=" + director + "]";

    // }

}
