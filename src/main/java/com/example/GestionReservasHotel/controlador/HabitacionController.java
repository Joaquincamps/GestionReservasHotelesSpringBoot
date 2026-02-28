package com.example.GestionReservasHotel.controlador;

import com.example.GestionReservasHotel.dto.habitacion.DtoEstadoHabitacion;
import com.example.GestionReservasHotel.modelo.Habitacion;
import com.example.GestionReservasHotel.modelo.enums.Estado;
import com.example.GestionReservasHotel.servicio.ServicioHabitacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    private final ServicioHabitacion servicioHabitacion;

    public HabitacionController(ServicioHabitacion servicioHabitacion) {
        this.servicioHabitacion = servicioHabitacion;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion habitacionCreada = servicioHabitacion.crearHabitacion(habitacion);
        return new ResponseEntity<>(habitacionCreada, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Habitacion> listarHabitaciones() {
        return servicioHabitacion.listarHabitaciones();
    }

    @PatchMapping("{id}/actualizarEstado")
    public ResponseEntity<?> actualizarEstado(@PathVariable Long id,
                                              @RequestBody DtoEstadoHabitacion dtoEstadoHabitacion) {
        servicioHabitacion.cambiarEstadoHabitacion(id, dtoEstadoHabitacion.getEstado());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> listarPorEstado(@RequestParam Estado estado) {
        servicioHabitacion.listarHabitacionesPorEstado();
        return ResponseEntity.ok().build();
    }
}
