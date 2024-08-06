package com.netflux.spring.jpa.h2.dto;

import com.netflux.spring.jpa.h2.model.Creator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatorDTO {
    private String name;
    private String imgURL;

    // otros métodos

    public Creator toCreator() {
        System.out.println("DTO:Esto es la creatorDTO id = " + name);
        System.out.println("DTO:Esto es la creatorDTO title = " + imgURL);

        Creator nueva = new Creator(

                this.name,
                this.imgURL);

        System.out.println("DTO:despues de nuevo toCreator = " + nueva.toString());

        return nueva;
    }

}
