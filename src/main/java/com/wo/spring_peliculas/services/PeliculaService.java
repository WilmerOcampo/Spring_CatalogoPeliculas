package com.wo.spring_peliculas.services;

import com.wo.spring_peliculas.dao.IPeliculaRepository;
import com.wo.spring_peliculas.entities.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    private IPeliculaRepository repos;

    @Override
    public void save(Pelicula movie) {
        repos.save(movie);
    }

    @Override
    public Pelicula findById(Long id) {
        return repos.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repos.deleteById(id);
    }

    @Override
    public List<Pelicula> findAll() {
        return (List<Pelicula>) repos.findAll();
    }
}
