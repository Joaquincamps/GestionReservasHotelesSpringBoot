package com.example.GestionReservasHotel.servicio;

import com.example.GestionReservasHotel.modelo.Habitacion;
import com.example.GestionReservasHotel.repositorio.HabitacionRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioHabitacion {

    private final HabitacionRepositorio habitacionRepositorio;

    public ServicioHabitacion(HabitacionRepositorio habitacionRepositorio) {
        this.habitacionRepositorio = habitacionRepositorio;
    }

    public Habitacion crearHabitacion(Habitacion habitacion) {
        return habitacionRepositorio.save(habitacion);
    }

    
}
