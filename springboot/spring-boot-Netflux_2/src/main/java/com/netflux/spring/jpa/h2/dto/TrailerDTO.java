package com.netflux.spring.jpa.h2.dto;

import com.netflux.spring.jpa.h2.model.Trailer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TrailerDTO {
    private String id;
    private String title;
    private String url;
    private String imgURL;

    public TrailerDTO() {
        this.id = null;
        this.title = null;
        this.url = null;
        this.imgURL = null;
    }

    public TrailerDTO(String id, String title, String url, String imgURL) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.imgURL = imgURL;
    }

}
