package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actor_id")
    private Integer id;

    @Column(name = "first_name")
    private String nombre;

    @Column(name = "last_name")
    private String apellido;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    // Método auxiliar para mostrar el nombre completo fácil en el HTML
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}