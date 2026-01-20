package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Alquiler {

    @Id
    @Column(name = "rental_id")
    private Integer id;

    @Column(name = "rental_date")
    private LocalDateTime fechaAlquiler;

    @Column(name = "return_date")
    private LocalDateTime fechaDevolucion;

    // Relación: El alquiler apunta a un ítem de Inventario
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventario inventario;

    // Relación: El alquiler pertenece a un Cliente
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Cliente cliente;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getFechaAlquiler() { return fechaAlquiler; }
    public void setFechaAlquiler(LocalDateTime fechaAlquiler) { this.fechaAlquiler = fechaAlquiler; }

    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public Inventario getInventario() { return inventario; }
    public void setInventario(Inventario inventario) { this.inventario = inventario; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}