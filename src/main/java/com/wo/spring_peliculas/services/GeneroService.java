package com.wo.spring_peliculas.services;

import com.wo.spring_peliculas.dao.IGeneroRepository;
import com.wo.spring_peliculas.entities.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {

    @Autowired
    private IGeneroRepository genreRepos;

    @Override
    public void save(Genero genre) {
        genreRepos.save(genre);
    }

    @Override
    public Genero findById(Long id) {
        return genreRepos.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        genreRepos.deleteById(id);
    }

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) genreRepos.findAll();
    }
}
