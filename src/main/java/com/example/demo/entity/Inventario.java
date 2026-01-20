package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventario {

    @Id
    @Column(name = "inventory_id")
    private Integer id;

    // Relación: Un inventario "tiene" una Película
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Pelicula pelicula;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Tienda tienda;

    public Tienda getTienda() { return tienda; }
    public void setTienda(Tienda tienda) { this.tienda = tienda; }
}