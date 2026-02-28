package com.example.GestionReservasHotel.controlador;

import com.example.GestionReservasHotel.dto.reserva.DtoReserva;
import com.example.GestionReservasHotel.modelo.Reserva;
import com.example.GestionReservasHotel.servicio.ServicioReserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ServicioReserva servicioReserva;

    public ReservaController(ServicioReserva servicioReserva) {
        this.servicioReserva = servicioReserva;
    }

    @PostMapping("/crear")
    public ResponseEntity<DtoReserva> crearReserva(@RequestBody DtoReserva dtoReserva) {
        servicioReserva.crearReserva(dtoReserva);
        return new ResponseEntity<>(dtoReserva, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable Long id) {
        servicioReserva.elimnarReservaPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
