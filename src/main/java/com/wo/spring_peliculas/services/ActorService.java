package com.wo.spring_peliculas.services;

import com.wo.spring_peliculas.dao.IActorRepository;
import com.wo.spring_peliculas.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired
    private IActorRepository repos;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) repos.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) repos.findAllById(ids);
    }
}
