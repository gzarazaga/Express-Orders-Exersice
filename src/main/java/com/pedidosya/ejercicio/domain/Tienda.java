package com.pedidosya.ejercicio.domain;

public class Tienda {
    Long id;

    public Tienda() {
    }

    public Tienda(Long id) {
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
        return "Tienda{" +
                "id=" + id +
                '}';
    }
}
