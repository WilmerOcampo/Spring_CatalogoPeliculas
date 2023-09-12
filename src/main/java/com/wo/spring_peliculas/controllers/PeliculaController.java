package com.wo.spring_peliculas.controllers;

import com.wo.spring_peliculas.entities.Actor;
import com.wo.spring_peliculas.entities.Pelicula;
import com.wo.spring_peliculas.services.IActorService;
import com.wo.spring_peliculas.services.IGeneroService;
import com.wo.spring_peliculas.services.IPeliculaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PeliculaController {

    private IPeliculaService service;
    private IGeneroService gservice;
    private IActorService aservice;


    public PeliculaController(IPeliculaService service, IGeneroService gservice, IActorService aservice) {
        this.service = service;
        this.gservice = gservice;
        this.aservice = aservice;
    }

    @GetMapping("/new-pelicula")
    public String create(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("genres", gservice.findAll());
        model.addAttribute("actors", aservice.findAll());
        model.addAttribute("titulo", "Nueva Película");
        return "new-pelicula";
    }

    @GetMapping("/pelicula/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        Pelicula pelicula = service.findById(id);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("genres", gservice.findAll());
        model.addAttribute("actors", aservice.findAll());
        //model.addAttribute("editactors", pelicula.getActors());
        model.addAttribute("titulo", "Editar Película");
        return "new-pelicula";
    }

    @PostMapping("/pelicula")
    public String save(@Valid Pelicula pelicula, BindingResult br, @ModelAttribute(name = "ids") String ids, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("genres", gservice.findAll());
            model.addAttribute("actors", aservice.findAll());
            return "new-pelicula";
        }

        List<Long> idActors = Arrays.stream(ids.split(", ")).map(Long::parseLong).collect(Collectors.toList());
        List<Actor> actors = aservice.findAllById(idActors);
        pelicula.setActors(actors);

        service.save(pelicula);
        return "redirect:peliculas";
    }

    @GetMapping("/peliculas")
    public String peliculas(Model model) {
        model.addAttribute("peliculas", service.findAll());
        model.addAttribute("actors", aservice.findAll());

        //model.addAttribute("msg", "Registro Existoso!");
        //model.addAttribute("tipoMsg", "success");
        return "peliculas";
    }

    @GetMapping("/list-peliculas")
    public String list(Model model) {
        model.addAttribute("titulo", "Listado de Películas");
        model.addAttribute("peliculas", service.findAll());

        return "list-peliculas";
    }

}
