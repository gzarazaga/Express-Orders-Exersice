package com.pedidosya.ejercicio.services;

import com.pedidosya.ejercicio.domain.Opinion;
import com.pedidosya.ejercicio.exceptions.OpinionNotFoundException;
import com.pedidosya.ejercicio.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OpinionService {

    private OpinionRepository opinionRepository;

    @Autowired
    public OpinionService(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    public Opinion addOpinion(Opinion opinion) {
        Opinion savedOpinion = opinionRepository.save(opinion);
        return savedOpinion;
    }

    public void deleteOpinion(Long opinionId) {
        Opinion opinion = opinionRepository.getById(opinionId);
        if (opinion.getOpinionEliminada()) {
            throw new OpinionNotFoundException(String.format("Opinion no encontrada %s", opinionId));
        }
        opinion.setOpinionEliminada(true);
        opinionRepository.save(opinion);
    }

    public Opinion getOpinionByCompraId(Long compraId) {
        Opinion opinion = opinionRepository.getByCompraId(compraId);
        if (opinion.getOpinionEliminada()) {
            throw new OpinionNotFoundException(String.format("Opinion no encontrada para la compra %s", compraId));
        }
        return opinionRepository.getByCompraId(compraId);
    }

    public List<Opinion> getOpinionByTiendaIdAndDateRange(Long tiendaId, Date fechaDesde, Date fechaHasta) {
        return opinionRepository.findByFechaDeCreacionAndTiendaId(fechaDesde, fechaHasta, tiendaId);
    }
}
