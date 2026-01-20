package com.example.demo.controller;

import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping("/")
    public String mostrarDashboard(Model model) {
        
        long totalPeliculas = peliculaRepository.count();
        long clientesActivos = clienteRepository.countByActivo(1);
        long totalAlquileres = alquilerRepository.count();
        

        var ingresosTotales = pagoRepository.sumarIngresosTotales();

        var ultimosAlquileres = alquilerRepository.findTop5ByOrderByFechaAlquilerDesc();

        model.addAttribute("totalPeliculas", totalPeliculas);
        model.addAttribute("clientesActivos", clientesActivos);
        model.addAttribute("totalAlquileres", totalAlquileres);
        model.addAttribute("ingresosTotales", ingresosTotales);
        model.addAttribute("ultimosAlquileres", ultimosAlquileres);

        return "home";
    }
}