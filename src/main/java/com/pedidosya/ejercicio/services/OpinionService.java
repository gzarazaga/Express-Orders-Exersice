package com.pedidosya.ejercicio.services;

import com.pedidosya.ejercicio.domain.Opinion;
import com.pedidosya.ejercicio.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Opinion opinion = new Opinion(opinionId);
        opinionRepository.delete(opinion);
    }
}
