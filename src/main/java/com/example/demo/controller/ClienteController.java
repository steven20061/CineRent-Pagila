package com.example.demo.controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AlquilerRepository alquilerRepository;

    @GetMapping("/clientes")
    public String listarClientes(@RequestParam(name = "buscar", required = false) String buscar, Model model) {
        if (buscar != null && !buscar.isEmpty()) {
            // Buscamos por nombre O apellido usando la misma palabra clave
            model.addAttribute("listaClientes", clienteRepository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(buscar, buscar));
        } else {
            // Si no buscan nada, mostramos todos
            model.addAttribute("listaClientes", clienteRepository.findAll());
        }
        model.addAttribute("palabraBusqueda", buscar); // Para que se quede escrito en la caja
        return "clientes";
    }

    @GetMapping("/clientes/{id}/historial")
    public String verHistorial(@PathVariable("id") Integer idCliente, Model model) {
        // 1. Buscamos los alquileres de ese cliente específico
        var historial = alquilerRepository.findByCliente_IdOrderByFechaAlquilerDesc(idCliente);
        
        // 2. Buscamos los datos del cliente para poner su nombre en el título
        var cliente = clienteRepository.findById(idCliente).orElse(null);

        // 3. Mandamos todo al HTML
        model.addAttribute("historial", historial);
        model.addAttribute("cliente", cliente);
        
        return "historial"; // <--- Buscará historial.html
    }
}