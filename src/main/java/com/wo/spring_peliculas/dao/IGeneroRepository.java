package com.wo.spring_peliculas.dao;

import com.wo.spring_peliculas.entities.Genero;
import org.springframework.data.repository.CrudRepository;

public interface IGeneroRepository extends CrudRepository<Genero, Long> {

}
