package com.pedidosya.ejercicio.controller;

import com.pedidosya.ejercicio.domain.Opinion;
import com.pedidosya.ejercicio.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pedidosya")
public class OpinionController {

    private OpinionService opinionService;

    @Autowired
    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @PostMapping("/opinion")
    public ResponseEntity<OpinionResponse> addOpinion(@RequestBody @Valid OpinionRequest opinionRequest) {
        Opinion opinion = convert(opinionRequest);

        Opinion savedOpinion = opinionService.addOpinion(opinion);

        OpinionResponse opinionResponse = convert(savedOpinion);

        return new ResponseEntity(opinionResponse, HttpStatus.OK);
    }

    @DeleteMapping("/opinion/{id}")
    public ResponseEntity deleteOpinion(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        opinionService.deleteOpinion(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    private OpinionResponse convert(Opinion savedOpinion) {
        OpinionResponse opinionResponse = new OpinionResponse(savedOpinion.getId(), savedOpinion.getDescripcion(), savedOpinion.getPuntuacion(), savedOpinion.getFechaDeCreacion(), savedOpinion.getCompraId(), savedOpinion.getUsuarioId(), savedOpinion.getTiendaId());
        return  opinionResponse;
    }

    private Opinion convert(OpinionRequest opinionRequest) {
        Opinion opinion = new Opinion(opinionRequest.getDescripcion(), opinionRequest.getPuntuacion(), opinionRequest.getFechaDeCreacion(), opinionRequest.getCompraId(), opinionRequest.getUsuarioId(), opinionRequest.getTiendaId(), false);
        return opinion;
    }
}
