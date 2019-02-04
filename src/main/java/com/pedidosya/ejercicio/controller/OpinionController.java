package com.pedidosya.ejercicio.controller;

import com.pedidosya.ejercicio.domain.Opinion;
import com.pedidosya.ejercicio.services.OpinionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value="Opinion", description="Opinion API")
public class OpinionController {

    private OpinionService opinionService;

    @Autowired
    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @PostMapping("/opinion")
    @ApiOperation(value = "Agregar una opinion", response = OpinionResponse.class)
    public ResponseEntity<OpinionResponse> addOpinion(@RequestBody @Valid OpinionRequest opinionRequest) {
        Opinion opinion = convert(opinionRequest);

        Opinion savedOpinion = opinionService.addOpinion(opinion);

        OpinionResponse opinionResponse = convert(savedOpinion);

        return new ResponseEntity(opinionResponse, HttpStatus.OK);
    }

    @PutMapping("/opinion/{id}")
    @ApiOperation(value = "Borrar una opinion", response = OpinionResponse.class)
    public ResponseEntity deleteOpinion(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        opinionService.deleteOpinion(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/opinion/compra/{id}")
    @ApiOperation(value = "Obtener una opinion para una compra", response = OpinionResponse.class)
    public ResponseEntity getOpinionByCompra(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Opinion opinion = opinionService.getOpinionByCompraId(id);
        OpinionResponse opinionResponse = convert(opinion);

        return new ResponseEntity(opinionResponse, HttpStatus.OK);
    }

    @GetMapping("/opinion/tienda/{id}")
    @ApiOperation(value = "Obtener opiniones de una tienda en un rango de fechas", response = Iterable.class)
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
