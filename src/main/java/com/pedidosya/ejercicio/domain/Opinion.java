package com.pedidosya.ejercicio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String descripcion;
    private Integer puntuacion;
    private Date fechaDeCreacion;
    private Compra  compra;
    private Usuario usuario;
    private Tienda tienda;
    private Boolean opinionEliminada;

    public Opinion() {

    }

    public Opinion(String descripcion, Integer puntuacion, Date fechaDeCreacion, Compra compra, Usuario usuario, Tienda tienda, Boolean opinionEliminada) {
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.compra = compra;
        this.usuario = usuario;
        this.tienda = tienda;
        this.opinionEliminada = opinionEliminada;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Boolean getOpinionEliminada() {
        return opinionEliminada;
    }

    public void setOpinionEliminada(Boolean opinionEliminada) {
        this.opinionEliminada = opinionEliminada;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "descripcion='" + descripcion + '\'' +
                ", puntuacion=" + puntuacion +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", compra=" + compra +
                ", usuario=" + usuario +
                ", tienda=" + tienda +
                ", opinionEliminada=" + opinionEliminada +
                '}';
    }
}
