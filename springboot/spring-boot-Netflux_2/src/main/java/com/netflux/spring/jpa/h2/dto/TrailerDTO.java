package com.netflux.spring.jpa.h2.dto;

import com.netflux.spring.jpa.h2.model.Trailer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrailerDTO {
    private String id;
    private String title;
    private String url;
    private String imgURL;

    // otros métodos

    public Long convertirStringToLong(String valor) {
        try {
            return Long.parseLong(valor);
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que el valor no es un número válido
            return 0L;
        }
    }

    public Trailer toTrailer() {
        System.out.println("DTO:Esto es la trailerDTO id = " + id);
        System.out.println("DTO:Esto es la trailerDTO title = " + title);
        System.out.println("DTO:Esto es la trailerDTO url = " + url);
        System.out.println("DTO:Esto es la trailerDTO imgURL = " + imgURL);

        Trailer nueva = new Trailer(

                convertirStringToLong(id),
                this.title,
                this.url,
                this.imgURL);

        System.out.println("DTO:despues de nuevo trailerDTO id = " + id);

        return nueva;
    }

}
