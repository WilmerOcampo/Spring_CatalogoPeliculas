package com.wo.spring_peliculas.services;

import com.wo.spring_peliculas.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {

    public void save(Pelicula movie);
    public Pelicula findById(Long id);
    public  void delete(Long id);
    public List<Pelicula> findAll();

}
