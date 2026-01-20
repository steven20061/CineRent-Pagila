package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film") // Nombre exacto en Postgres
public class Pelicula {

    @Id
    @Column(name = "film_id")
    private Integer id;

    @Column(name = "title")
    private String titulo;

    @Column(name = "release_year")
    private Integer anioLanzamiento;

    @Column(name = "description")
    private String descripcion;

    @Column(name = "rating")
    private String clasificacion;

    // Getters y Setters (Obligatorios)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public Integer getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(Integer anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
}