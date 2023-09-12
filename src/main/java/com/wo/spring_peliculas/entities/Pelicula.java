package com.wo.spring_peliculas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Completar el campo")
    private String title;

    @Column(name = "fec_est")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Seleccione la fecha")
    private Date release;

    @ManyToOne
    @NotNull()
    private Genero genre;

    @ManyToMany
    private List<Actor> actors;

    @NotNull(message = "Ingrese URL de Portada")
    private String cover;

}