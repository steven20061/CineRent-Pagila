package com.example.demo.repository;

import com.example.demo.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    
    // Consulta JPQL para sumar todos los pagos
    @Query("SELECT SUM(p.monto) FROM Pago p")
    BigDecimal sumarIngresosTotales();
    @Query(value = "SELECT TO_CHAR(payment_date, 'YYYY-MM') as mes, SUM(amount) as total " +
                   "FROM payment " +
                   "GROUP BY mes " +
                   "ORDER BY mes DESC", nativeQuery = true)
    List<IngresoMensualDTO> obtenerIngresosMensuales();
}