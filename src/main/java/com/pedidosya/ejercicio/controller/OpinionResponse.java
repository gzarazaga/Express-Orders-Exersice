package com.pedidosya.ejercicio.controller;

import java.util.Date;

public class OpinionResponse {
    private Long opinionId;
    private String descripcion;
    private Integer puntuacion;
    private Date fechaDeCreacion;
    private Long  compraId;
    private Long usuarioId;
    private Long tiendaId;

    public OpinionResponse() {
    }

    public OpinionResponse(Long opinionId, String descripcion, Integer puntuacion, Date fechaDeCreacion, Long compraId, Long usuarioId, Long tiendaId) {
        this.opinionId = opinionId;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.compraId = compraId;
        this.usuarioId = usuarioId;
        this.tiendaId = tiendaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(Long tiendaId) {
        this.tiendaId = tiendaId;
    }

    public Long getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Long opinionId) {
        this.opinionId = opinionId;
    }

    @Override
    public String toString() {
        return "OpinionResponse{" +
                "opinionId='" + opinionId + '\'' +
                "descripcion='" + descripcion + '\'' +
                ", puntuacion=" + puntuacion +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", compraId=" + compraId +
                ", usuarioId=" + usuarioId +
                ", tiendaId=" + tiendaId +
                '}';
    }
}
