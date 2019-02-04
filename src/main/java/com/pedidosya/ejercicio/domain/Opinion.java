package com.pedidosya.ejercicio.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String descripcion;
    private Integer puntuacion;
    private Date fechaDeCreacion;
    @Column(unique=true)
    private Long  compraId;
    private Long usuarioId;
    private Long tiendaId;
    private Boolean opinionEliminada;

    public Opinion() {

    }

    public Opinion(String descripcion, Integer puntuacion, Date fechaDeCreacion, Long compraId, Long usuarioId, Long tiendaId, Boolean opinionEliminada) {
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.setCompraId(compraId);
        this.setUsuarioId(usuarioId);
        this.setTiendaId(tiendaId);
        this.opinionEliminada = opinionEliminada;
    }

    public Opinion(Long opinionId) {
        this.id = opinionId;
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

    public Boolean getOpinionEliminada() {
        return opinionEliminada;
    }

    public void setOpinionEliminada(Boolean opinionEliminada) {
        this.opinionEliminada = opinionEliminada;
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

    @Override
    public String toString() {
        return "Opinion{" +
                "descripcion='" + descripcion + '\'' +
                ", puntuacion=" + puntuacion +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", compraId=" + getCompraId() +
                ", usuarioId=" + getUsuarioId() +
                ", tiendaId=" + getTiendaId() +
                ", opinionEliminada=" + opinionEliminada +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
