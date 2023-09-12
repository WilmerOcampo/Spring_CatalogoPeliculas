package com.wo.spring_peliculas.dao;

import com.wo.spring_peliculas.entities.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepository extends CrudRepository<Actor, Long> {

}
