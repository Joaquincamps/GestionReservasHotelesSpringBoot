package com.example.GestionReservasHotel.dto.habitacion;

import com.example.GestionReservasHotel.modelo.enums.Estado;

public class DtoFiltrarPorEstado {

    private Long id;

    private Estado estado;

    public DtoFiltrarPorEstado() {
    }

    public DtoFiltrarPorEstado(Long id, Estado estado) {
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
