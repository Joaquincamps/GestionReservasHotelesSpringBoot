package com.example.GestionReservasHotel.dto.habitacion;

import com.example.GestionReservasHotel.modelo.enums.habitacion.Tipo;

public class DtoFiltrarPorTipo {

    private Long id;

    private Tipo tipo;

    public DtoFiltrarPorTipo() {
    }

    public DtoFiltrarPorTipo(Long id, Tipo tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
