package com.example.demo.controller;

import com.example.demo.entity.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class CineController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private ActorRepository actorRepository;

   @GetMapping("/catalogo")
    public String mostrarPeliculas(
            @RequestParam(name = "buscar", required = false) String buscar, 
            @RequestParam(name = "rating", required = false) String rating,
            @RequestParam(name = "categoria", required = false) Integer categoriaId,
            @RequestParam(name = "actor", required = false) Integer actorId,
            Model model) {
        

        String tituloLimpio = (buscar != null && !buscar.isEmpty()) ? buscar : null;
        String ratingLimpio = (rating != null && !rating.isEmpty()) ? rating : null;
        Integer categoriaLimpia = (categoriaId != null && categoriaId > 0) ? categoriaId : null;
        Integer actorLimpio = (actorId != null && actorId > 0) ? actorId : null;


        List<Pelicula> listaPeliculas = peliculaRepository.buscarPeliculasConFiltros(
                tituloLimpio, ratingLimpio, categoriaLimpia, actorLimpio
        );


        model.addAttribute("peliculas", listaPeliculas);
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("actores", actorRepository.findAllByOrderByNombreAsc());


        model.addAttribute("palabraBusqueda", buscar);
        model.addAttribute("ratingSeleccionado", rating);
        model.addAttribute("categoriaSeleccionada", categoriaId);
        model.addAttribute("actorSeleccionado", actorId);
        
        return "catalogo";
    }
    }