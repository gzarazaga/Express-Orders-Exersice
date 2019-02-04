package com.pedidosya.ejercicio.controller;

import com.pedidosya.ejercicio.domain.Opinion;
import com.pedidosya.ejercicio.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/opinion/compra/{id}")
    public ResponseEntity getOpinionByCompra(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Opinion opinion = opinionService.getOpinionByCompraId(id);
        OpinionResponse opinionResponse = convert(opinion);

        return new ResponseEntity(opinionResponse, HttpStatus.OK);
    }

    @GetMapping("/opinion/tienda/{id}")
    public ResponseEntity getOpinionByTiendaAndDateRange(@PathVariable Long id, @RequestBody QueryRequest queryRequest) {
        if (id == null || queryRequest  == null || queryRequest.getFechaDesde()  == null || queryRequest.getFechaHasta() == null ) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        List<Opinion> opinions = opinionService.getOpinionByTiendaIdAndDateRange(id, queryRequest.getFechaDesde(), queryRequest.getFechaHasta());
        List<OpinionResponse> opinionResponses = convert(opinions);

        return new ResponseEntity(opinionResponses, HttpStatus.OK);
    }

    private List<OpinionResponse> convert(List<Opinion> opinions) {
        List<OpinionResponse> responses = new ArrayList<>();

        for (Opinion opinion: opinions) {
            responses.add(convert(opinion));
        }
        return  responses;
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
