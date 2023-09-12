package com.wo.spring_peliculas.controllers;

import com.wo.spring_peliculas.entities.Genero;
import com.wo.spring_peliculas.services.IGeneroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroService service;

    public GeneroController(IGeneroService service) {
        this.service = service;
    }

    @PostMapping("genre")
    public Long save(@RequestParam String name){
        Genero genre = new Genero();
        genre.setName(name);

        service.save(genre);

        return genre.getId();
    }

    @GetMapping("genres/{id}")
    public String findById(@PathVariable(name = "id") Long id){
        return service.findById(id).getName();
    }

}
