package com.example.demo.repository;

import com.example.demo.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    // Ordenamos por nombre para que el menú salga bonito
    // Spring Data lo hace solo con este nombre de método:
    java.util.List<Actor> findAllByOrderByNombreAsc(); 
}