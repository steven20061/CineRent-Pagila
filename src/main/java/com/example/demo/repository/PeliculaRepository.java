package com.example.demo.repository;

import com.example.demo.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {


    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);


@Query(value = "SELECT DISTINCT f.* FROM film f " +
                   "LEFT JOIN film_category fc ON f.film_id = fc.film_id " +
                   "LEFT JOIN film_actor fa ON f.film_id = fa.film_id " +
                   "WHERE (:titulo IS NULL OR LOWER(f.title) LIKE LOWER(CONCAT('%', :titulo, '%'))) " +
                   "AND (:rating IS NULL OR f.rating = CAST(:rating AS mpaa_rating)) " +
                   "AND (:categoriaId IS NULL OR fc.category_id = :categoriaId) " +
                   "AND (:actorId IS NULL OR fa.actor_id = :actorId)", 
           nativeQuery = true)
    List<Pelicula> buscarPeliculasConFiltros(
            @Param("titulo") String titulo, 
            @Param("rating") String rating,
            @Param("categoriaId") Integer categoriaId,
            @Param("actorId") Integer actorId);
}