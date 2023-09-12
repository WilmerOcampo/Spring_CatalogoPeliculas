package com.wo.spring_peliculas.services;

import com.wo.spring_peliculas.entities.Actor;
import com.wo.spring_peliculas.entities.Pelicula;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll();
    public  List<Actor> findAllById(List<Long> ids);
}
