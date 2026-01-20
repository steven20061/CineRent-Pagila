package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Categoria {

    @Id
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "name")
    private String nombre;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}