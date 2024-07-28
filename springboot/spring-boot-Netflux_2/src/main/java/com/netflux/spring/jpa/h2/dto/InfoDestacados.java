package com.netflux.spring.jpa.h2.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class InfoDestacados {
    private String id;
    private String type;
    private String url;
    private String title;
    private String imgURL;

    // Constructor

    // public InfoDestacados(String id, String type, String url, String title,
    // String imgURL) {
    // this.id = id;
    // this.type = type;
    // this.url = url;
    // this.title = title;
    // this.imgURL = imgURL;
    // }

    // Getters y Setters

}
