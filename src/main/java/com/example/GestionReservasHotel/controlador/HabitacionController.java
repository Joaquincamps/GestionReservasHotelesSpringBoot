package com.example.GestionReservasHotel.controlador;

import com.example.GestionReservasHotel.dto.habitacion.DtoEstadoHabitacion;
import com.example.GestionReservasHotel.dto.habitacion.DtoFiltrarPorEstado;
import com.example.GestionReservasHotel.dto.habitacion.DtoFiltrarPorTipo;
import com.example.GestionReservasHotel.modelo.Habitacion;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Estado;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Tipo;
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

    @GetMapping("/estado/resumen/{estado}")
    public List<DtoFiltrarPorEstado> listarPorEstado(@PathVariable Estado estado) {
        return servicioHabitacion.listarHabitacionesPorEstado(estado);
    }

    @GetMapping("/estado/{estado}")
    public List<Habitacion> mostrarTodoHabitacionesEstado(@PathVariable Estado estado) {
        return servicioHabitacion.listarTodoDeHabitacionesPorEstado(estado);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Habitacion> listarPorTipo(@PathVariable Tipo tipo) {
        return servicioHabitacion.listarHabitacionesPorTipo(tipo);
    }

    @GetMapping("/tipo/resumen/{tipo}")
    public List<DtoFiltrarPorTipo> listarPorTipoResumen(@PathVariable Tipo tipo) {
        return servicioHabitacion.listarHabitacionResumenPorTipo(tipo);
    }
}
