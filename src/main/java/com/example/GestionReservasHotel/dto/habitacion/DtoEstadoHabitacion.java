package com.example.GestionReservasHotel.dto.habitacion;

import com.example.GestionReservasHotel.modelo.enums.habitacion.Estado;
import org.antlr.v4.runtime.misc.NotNull;

public class DtoEstadoHabitacion {

    @NotNull
    private Estado estado;

    public DtoEstadoHabitacion() {
    }

    public DtoEstadoHabitacion(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
