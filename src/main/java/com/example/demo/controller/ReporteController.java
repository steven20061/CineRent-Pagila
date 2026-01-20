package com.example.demo.controller;

import com.example.demo.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteController {

    @Autowired
    private com.example.demo.repository.PagoRepository pagoRepository;
    @Autowired
    private AlquilerRepository alquilerRepository;

@GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        
        // 1. Rankings (Lo que ya tenías)
        var topPeliculas = alquilerRepository.encontrarTopPeliculas(PageRequest.of(0, 10));
        var topClientes = alquilerRepository.encontrarTopClientes(PageRequest.of(0, 10));

        // 2. NUEVO: Ingresos Mensuales
        var ingresosMensuales = pagoRepository.obtenerIngresosMensuales();

        model.addAttribute("topPeliculas", topPeliculas);
        model.addAttribute("topClientes", topClientes);
        model.addAttribute("ingresosMensuales", ingresosMensuales); // <-- Enviamos esto
        
        return "reportes";
    }
}