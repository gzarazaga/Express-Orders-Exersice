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

    public void addOpinion(Opinion opinion) {
        opinionRepository.save(opinion);
    }
}
