package com.example.demo.repository;

import com.example.demo.entity.Alquiler;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

    // 1. HISTORIAL DEL CLIENTE
    // Busca alquileres de un cliente específico (para la pantalla de Clientes)
    List<Alquiler> findByCliente_IdOrderByFechaAlquilerDesc(Integer clienteId);

    // 2. DASHBOARD (Últimos Movimientos)
    // Trae los 5 alquileres más recientes de toda la tienda
    List<Alquiler> findTop5ByOrderByFechaAlquilerDesc();

    // 3. REPORTE: TOP PELÍCULAS MÁS ALQUILADAS
    // Cuenta cuántas veces aparece cada película en los alquileres
    @Query("SELECT i.pelicula.titulo as titulo, COUNT(r) as cantidad " +
           "FROM Alquiler r JOIN r.inventario i " +
           "GROUP BY i.pelicula.titulo " +
           "ORDER BY cantidad DESC")
    List<TopPeliculaDTO> encontrarTopPeliculas(Pageable pageable);

    // 4. REPORTE: TOP CLIENTES (VIPs)
    // Cuenta quiénes son los clientes que más alquilan
    @Query("SELECT r.cliente.nombre as nombre, r.cliente.apellido as apellido, COUNT(r) as cantidad " +
           "FROM Alquiler r " +
           "GROUP BY r.cliente.id, r.cliente.nombre, r.cliente.apellido " +
           "ORDER BY cantidad DESC")
    List<TopClienteDTO> encontrarTopClientes(Pageable pageable);

    // 5. BUSCADOR DE RENTAS (Fechas + Tienda)
    // Filtra por un rango de fechas obligatorias y una tienda opcional
    @Query("SELECT r FROM Alquiler r " +
           "JOIN r.inventario i " +
           "JOIN i.tienda t " +
           "WHERE r.fechaAlquiler BETWEEN :inicio AND :fin " +
           "AND (:storeId IS NULL OR t.id = :storeId)")
    List<Alquiler> buscarPorFechasYTienda(
            @Param("inicio") LocalDateTime inicio, 
            @Param("fin") LocalDateTime fin,
            @Param("storeId") Integer storeId);
}