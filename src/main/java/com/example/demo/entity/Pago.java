package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Pago {

    @Id
    @Column(name = "payment_id")
    private Integer id;

    @Column(name = "amount")
    private BigDecimal monto; // Usamos BigDecimal para dinero (es más exacto que Double)

    @Column(name = "payment_date")
    private LocalDateTime fechaPago;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
}