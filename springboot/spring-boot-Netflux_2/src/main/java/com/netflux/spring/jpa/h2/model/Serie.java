package com.netflux.spring.jpa.h2.model;

import java.util.List;

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
@Table(name = "series")
public class Serie {
    /*
     * @Id
     * 
     * @Column(name = "id")
     * private String id;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "url", length = 255, nullable = false)
    private String url;

    @Column(name = "img_url", length = 255, nullable = false)
    private String imgURL;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "yearstart", nullable = false)
    private Integer yearstart;

    @Column(name = "yearend", nullable = false)
    private Integer yearend;

    @Column(name = "seasons", nullable = false)
    private Integer seasons;

    // ---Relaciones y sus
    // atributos-------------------------------------------------------------------------

    @ManyToMany(mappedBy = "series_infocasts") // se pone el nombre del atributo en la clase model (en este caso
                                               // series), no
    // dela tabla
    private List<Infocast> series_infocasts;

    @ManyToMany(mappedBy = "series")
    private List<Creator> creators;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_series_id")
    // private SerieDestacada seriesDestacadas;

    // ---Fin
    // relaciones----------------------------------------------------------------

    public Serie(String url, String imgURL, String title, String description,
            Integer yearstart, Integer yearend, Integer seasons, List<Infocast> infocasts, List<Creator> creators) {
        // this.id = id;
        this.url = url;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.yearstart = yearstart;
        this.yearend = yearend;
        this.seasons = seasons;
        this.series_infocasts = infocasts;
        this.creators = creators;
    }

    public long getId() {
        return id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearStart() {
        return yearstart;
    }

    public void setYearStart(Integer yearstart) {
        this.yearstart = yearstart;
    }

    public Integer getYearEnd() {
        return yearend;
    }

    public void setYearEnd(Integer yearend) {
        this.yearend = yearend;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public List<Infocast> getInfocast() {
        return this.series_infocasts;
    }

    public void setInfocast(List<Infocast> infocasts) {
        this.series_infocasts = infocasts;
    }

    public List<Creator> getCreators() {
        return this.creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

}
