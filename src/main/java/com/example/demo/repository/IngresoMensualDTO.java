package com.example.demo.repository;

import java.math.BigDecimal;

public interface IngresoMensualDTO {
    String getMes();      // Ejemplo: "2022-05"
    BigDecimal getTotal(); // Ejemplo: 5400.50
}