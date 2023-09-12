package com.wo.spring_peliculas.services;

import com.wo.spring_peliculas.entities.Genero;

import java.util.List;

public interface IGeneroService {
    public void save(Genero genre);
    public  Genero findById(Long id);
    public void delete(Long id);
    public List<Genero> findAll();
}
