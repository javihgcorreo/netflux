package com.netflux.spring.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.netflux.spring.jpa.h2.repository.InfocastRepository;

import com.netflux.spring.jpa.h2.model.Infocast;
import com.netflux.spring.jpa.h2.dto.InfocastDTO;

import com.netflux.spring.jpa.h2.service.InfocastService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class InfocastService {
    @Autowired
    private InfocastRepository infocastRepository;

    public List<InfocastDTO> getAllInfocasts() {
        List<Infocast> infocasts = infocastRepository.findAll();
        if (infocasts == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        // Mapear Infocasts
        List<InfocastDTO> infoDestacadosObjects = infocasts.stream()
                .map(infocast -> {
                    InfocastDTO InfocastDTO = new InfocastDTO();
                    InfocastDTO.setName(infocast.getName());
                    InfocastDTO.setImgURL(infocast.getImgUrl());

                    // ... mapear otros campos
                    return InfocastDTO;
                })
                .collect(Collectors.toList());

        // Check if infoDestacadosObjects is null
        if (infoDestacadosObjects == null) {
            return Collections.unmodifiableList(Collections.emptyList());
        }

        return infoDestacadosObjects;
    }

    public InfocastDTO getInfocastById(Long id) {
        Optional<Infocast> infocastOpcional = infocastRepository.findById(id);// pido la infocast al repositorio de la
        // BBDD

        Infocast infocast = infocastOpcional.orElse(new Infocast()); // Si está vacío, crea una nueva Infocast, capturo
        // la Infocast

        InfocastDTO infocastDTO = new InfocastDTO(
                infocast.getName(),
                infocast.getImgUrl());

        System.out.println("Infocast = " + infocastDTO);

        return infocastDTO;

        // return infocastRepository.findById(id).orElse(null);

    }

    public Infocast crear(InfocastDTO infocastDTO) {
        // logger.info(infocast.toString());
        System.out.println("Service:Esto es la infocast = " + (infocastDTO.toString()));
        Infocast nuevaInfocast = infocastDTO.toInfocast();
        return infocastRepository.save(nuevaInfocast);
    }

    public ResponseEntity<Infocast> actualizar(Long id, Infocast infocastActualizada) {
        try {
            // logger.info(infocast.toString());
            System.out.println("Service:Esto es la infocast = " + (infocastActualizada.toString()));
            // Infocast nuevaInfocast = infocast.toInfocast();

            Optional<Infocast> infocastExistenteOpcional = infocastRepository.findById(id);
            Infocast infocastExistente = infocastExistenteOpcional.orElse(new Infocast()); // Si está vac

            return new ResponseEntity<>((infocastRepository.save(infocastExistente)),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public void deleteInfocast(Long id) {
        infocastRepository.deleteById(id);
    }

}
