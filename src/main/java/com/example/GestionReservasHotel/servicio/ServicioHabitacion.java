package com.example.GestionReservasHotel.servicio;

import com.example.GestionReservasHotel.dto.habitacion.DtoFiltrarPorEstado;
import com.example.GestionReservasHotel.dto.habitacion.DtoFiltrarPorTipo;
import com.example.GestionReservasHotel.modelo.Habitacion;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Estado;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Tipo;
import com.example.GestionReservasHotel.repositorio.HabitacionRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioHabitacion {

    private final HabitacionRepositorio habitacionRepositorio;

    public ServicioHabitacion(HabitacionRepositorio habitacionRepositorio) {
        this.habitacionRepositorio = habitacionRepositorio;
    }

    public Habitacion crearHabitacion(Habitacion habitacion) {
        return habitacionRepositorio.save(habitacion);
    }

    public void cambiarEstadoHabitacion(Long id, Estado nuevoEstado) {

        Habitacion habitacionBuscar = habitacionRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Habitación no encontrada"));
        Estado estado = habitacionBuscar.getEstado();

        if (estado.equals(nuevoEstado)) {
            throw new IllegalStateException("No se puede aplicar el mismo estado.");
        }
        habitacionBuscar.setEstado(nuevoEstado);
        habitacionRepositorio.save(habitacionBuscar);
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionRepositorio.findAll();
    }

    public List<DtoFiltrarPorEstado> listarHabitacionesPorEstado(Estado estado) {
        List<Habitacion> listaHabitaciones = habitacionRepositorio.findByEstado(estado);

        return listaHabitaciones.stream()
                .map(h -> new DtoFiltrarPorEstado(
                        h.getId(), h.getEstado()
                )).collect(Collectors.toList());
    }

    public List<Habitacion> listarTodoDeHabitacionesPorEstado(Estado estado) {
        return habitacionRepositorio.findByEstado(estado);
    }

    public List<Habitacion> listarHabitacionesPorTipo(Tipo tipo) {
        return habitacionRepositorio.findByTipo(tipo);
    }

    public List<DtoFiltrarPorTipo> listarHabitacionResumenPorTipo(Tipo tipo) {
        List<Habitacion> habitaciones = habitacionRepositorio.findByTipo(tipo);
        return habitaciones.stream()
                .map(h -> new DtoFiltrarPorTipo(
                        h.getId(),
                        h.getTipo()
                )).collect(Collectors.toList());
    }
}
