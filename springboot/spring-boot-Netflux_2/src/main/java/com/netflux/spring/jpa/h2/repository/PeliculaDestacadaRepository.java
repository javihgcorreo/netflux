package com.netflux.spring.jpa.h2.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.netflux.spring.jpa.h2.dto.InfoDestacados;
import com.netflux.spring.jpa.h2.model.Pelicula;
import com.netflux.spring.jpa.h2.model.PeliculaDestacada;

@Repository
public interface PeliculaDestacadaRepository extends JpaRepository<PeliculaDestacada, Long> {
    // @Query("SELECT p FROM Pelicula p JOIN PeliculasDestacadas pd ON p.id =
    // pd.pelicula_id")
    // List<Pelicula> findPeliculasDestacadas();

    List<PeliculaDestacada> findAll();

    // @Query("SELECT new InfoDestacados(p.id,'film',p.title,p.url, p.imgURL) FROM
    // PeliculaDestacada p")
    // List<InfoDestacados> findAllInfoDestacados();

    // no consigo con proyecciones a DTO InfoDestacados
    // @Query("SELECT new
    // com.netflux.spring.jpa.h2.dto.InfoDestacados(p.id,'film',p.url,p.title,p.imgURL)
    // FROM PeliculaDestacada p")
    // List<InfoDestacados> findAllToInfoDestacados();

    // @Query("SELECT p FROM Pelicula p JOIN PeliculasDestacadas pd ON p.id =
    // pd.pelicula_id")
    // List<Pelicula> findAllInfoDestacados();
    // List<PeliculaDestacada> findAll();

    // @Query(value = "SELECT new ResultDTO(c.id, o.id, p.id, c.name, c.email,
    // o.orderDate, p.productName, p.price) "
    // + " from Customer c, CustomerOrder o ,Product p "
    // + " where c.id=o.customer.id "
    // + " and o.id=p.customerOrder.id "
    // + " and c.id=?1 ")
    // List<ResultDTO> findResultDTOByCustomer(Long id);

}
