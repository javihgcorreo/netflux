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

public class InfoAbreviada {
    private String id;
    private String url;
    private String title;
    private String imgURL;

    // Getters y Setters
}
