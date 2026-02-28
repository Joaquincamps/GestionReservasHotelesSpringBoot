package com.example.GestionReservasHotel.dto.reserva;

import com.example.GestionReservasHotel.modelo.enums.gestionReservas.EstadoReservas;

public class DtoFinalizarReserva {

    private EstadoReservas estadoReservas;

    public DtoFinalizarReserva(EstadoReservas estadoReservas) {
        this.estadoReservas = estadoReservas;
    }

    public DtoFinalizarReserva() {
    }

    public EstadoReservas getEstadoReservas() {
        return estadoReservas;
    }

    public void setEstadoReservas(EstadoReservas estadoReservas) {
        this.estadoReservas = estadoReservas;
    }
}
