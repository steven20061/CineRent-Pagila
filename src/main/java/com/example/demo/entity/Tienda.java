package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Tienda {

    @Id
    @Column(name = "store_id")
    private Integer id;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}