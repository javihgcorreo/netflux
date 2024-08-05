package com.netflux.spring.jpa.h2.dto;

import com.netflux.spring.jpa.h2.model.Infocast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfocastDTO {
    private String name;
    private String imgURL;

    // Constructor
    // public InfocastDTO(String name, String imgURL) {
    // this.name = name;
    // this.imgURL = imgURL;
    // }

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

    // otros métodos

    public Infocast toInfocast() {
        Infocast nueva = new Infocast(
                this.name,
                this.imgURL);
        return nueva;
    }

}