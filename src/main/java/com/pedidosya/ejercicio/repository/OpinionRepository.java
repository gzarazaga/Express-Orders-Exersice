package com.pedidosya.ejercicio.repository;

import com.pedidosya.ejercicio.domain.Opinion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OpinionRepository extends CrudRepository<Opinion, Long> {

    public Opinion getById(Long id);

    public Opinion getByCompraId(Long compraId);

    @Query("SELECT o FROM Opinion o WHERE o.opinionEliminada = false and o.tiendaId = :tiendaId and o.fechaDeCreacion BETWEEN :fechaDesde AND :fechaHasta ")
    public List<Opinion> findByFechaDeCreacionAndTiendaId(@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta, @Param("tiendaId") Long tiendaId);

}
