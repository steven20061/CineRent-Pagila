package com.example.demo.controller;

import com.example.demo.repository.AlquilerRepository;
import com.example.demo.repository.TiendaRepository; // NUEVO IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class AlquilerController {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private TiendaRepository tiendaRepository; // NUEVO

    @GetMapping("/rentas")
    public String buscarPorFechas(
            @RequestParam(value = "desde", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam(value = "hasta", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
            @RequestParam(value = "tienda", required = false) Integer tiendaId, // NUEVO PARÁMETRO
            Model model) {

        // Siempre enviamos la lista de tiendas para el select
        model.addAttribute("tiendas", tiendaRepository.findAll());

        if (desde != null && hasta != null) {
            LocalDateTime fechaInicio = desde.atStartOfDay(); 
            LocalDateTime fechaFin = hasta.atTime(23, 59, 59);
            
            // Limpieza del ID de tienda (si es 0 o null, enviamos null)
            Integer filtroTienda = (tiendaId != null && tiendaId > 0) ? tiendaId : null;

            var lista = alquilerRepository.buscarPorFechasYTienda(fechaInicio, fechaFin, filtroTienda);
            model.addAttribute("rentas", lista);
        } else {
            model.addAttribute("rentas", null);
        }

        // Mantener seleccionados los valores en pantalla
        model.addAttribute("tiendaSeleccionada", tiendaId);
        
        return "rentas";
    }
}