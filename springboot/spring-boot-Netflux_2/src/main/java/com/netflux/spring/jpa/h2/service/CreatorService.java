package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflux.spring.jpa.h2.repository.CreatorRepository;
import com.netflux.spring.jpa.h2.model.Creator;
import com.netflux.spring.jpa.h2.dto.CreatorDTO;

import com.netflux.spring.jpa.h2.service.CreatorService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    public List<CreatorDTO> getAllCreators() {

        //
        // Creators-----------------------------------------------------------------

        List<Creator> creators = creatorRepository.findAll();

        // Mapear Creators a CreatorDTO
        List<CreatorDTO> infoAbreviadasObjects = creators.stream()
                .map(creator -> {
                    CreatorDTO infoAbreviada = new CreatorDTO();
                    // infoAbreviada.setId(Long.toString(creator.getId()));
                    infoAbreviada.setName(creator.getName());
                    infoAbreviada.setImgURL(creator.getImgURL());

                    // ... mapear otros campos
                    return infoAbreviada;
                })
                .collect(Collectors.toList());
        System.out.println("creatorService getAllCreatorsNovedosasSalir " + infoAbreviadasObjects);

        return infoAbreviadasObjects;
    }

    public CreatorDTO getCreatorById(Long id) {
        Optional<Creator> creatorOpcional = creatorRepository.findById(id);// pido la creator al repositorio de la
                                                                           // BBDD

        Creator creator = creatorOpcional.orElse(new Creator()); // Si está vacío, crea una nueva Creator, capturo
                                                                 // la Creator

        // Mapear Creators a InfoDestacados, uso el constructor del DTO
        CreatorDTO CreatorDTO = new CreatorDTO(
                // Long.toString(creator.getId()),
                creator.getName(),
                creator.getImgURL());

        System.out.println("CreatorDTO = " + CreatorDTO);

        return CreatorDTO;

    }

    public Creator crear(CreatorDTO creator) {
        // logger.info(creator.toString());
        System.out.println("Service:Esto es la creator = " + (creator.toString()));
        Creator nuevaCreator = creator.toCreator();
        System.out.println("Service:Despues de creatorDTO");

        return creatorRepository.save(nuevaCreator);
    }

    public ResponseEntity<CreatorDTO> actualizar(Long id, CreatorDTO creatorActualizada) {
        try {
            // logger.info(creator.toString());
            System.out.println("Service:Esto es la creator = " + (creatorActualizada.toString()));
            // Creator nuevaCreator = creator.toCreator();

            Optional<Creator> creatorExistenteOpcional = creatorRepository.findById(id);
            Creator creatorExistente = creatorExistenteOpcional.orElse(new Creator()); // Si está vac

            creatorExistente = creatorActualizada.toCreator();
            creatorExistente.setId(id);

            return new ResponseEntity<>((creatorRepository.save(creatorExistente)).toCreatorDTOSinInfocast(),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public void deleteCreator(Long id) {
        creatorRepository.deleteById(id);
    }
}