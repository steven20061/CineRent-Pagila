package com.example.demo.repository;

import com.example.demo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Aquí podremos agregar buscadores más tarde si quieres
    List<Cliente> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
    long countByActivo(Integer activo); // Spring cuenta automáticamente donde activo = 1
}