package com.pedidosya.ejercicio.domain;

import java.util.Date;

public class Compra {
    Long id;

    public Compra() {
    }

    public Compra(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                '}';
    }
}
