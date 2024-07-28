package com.netflux.spring.jpa.h2.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class InfocastDTO {
    private String name;
    private String imgURL;

    // Constructor
    public InfocastDTO(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    // Getters y Setters

    public String getImgURL() {
        return this.imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}