package com.wo.spring_peliculas.dao;

import com.wo.spring_peliculas.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {

}
