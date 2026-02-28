package com.example.GestionReservasHotel.servicio;

import com.example.GestionReservasHotel.dto.reserva.DtoReserva;
import com.example.GestionReservasHotel.modelo.Cliente;
import com.example.GestionReservasHotel.modelo.Habitacion;
import com.example.GestionReservasHotel.modelo.Reserva;
import com.example.GestionReservasHotel.modelo.enums.gestionReservas.EstadoReservas;
import com.example.GestionReservasHotel.repositorio.ClienteRepository;
import com.example.GestionReservasHotel.repositorio.HabitacionRepositorio;
import com.example.GestionReservasHotel.repositorio.ReservaRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ServicioReserva {

    private static final Double PRECIO_NOCHE = 58.6;

    private ReservaRepositorio reservaRepositorio;

    private ClienteRepository clienteRepository;

    private HabitacionRepositorio habitacionRepositorio;

    public ServicioReserva(ReservaRepositorio reservaRepositorio, ClienteRepository clienteRepository, HabitacionRepositorio habitacionRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
        this.clienteRepository = clienteRepository;
        this.habitacionRepositorio = habitacionRepositorio;
    }

    public void crearReserva(DtoReserva dtoReserva) {
        Cliente clienteBuscar = clienteRepository.findById(dtoReserva.getIdCliente()).
                orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Habitacion habitacionBuscar = habitacionRepositorio.findById(
                dtoReserva.getIdHabitacion()
        ).orElseThrow(() -> new RuntimeException("No se encontró la habitación"));

        Reserva reserva = new Reserva();
        reserva.setCliente(clienteBuscar);
        reserva.setHabitacion(habitacionBuscar);
        reserva.setFechaInicio(dtoReserva.getFecha_inicio());
        reserva.setFechaFin(dtoReserva.getFecha_fin());
        reserva.setEstado(EstadoReservas.ACTIVA);
        reserva.setPrecioTotal(calcularPrecio());

        reservaRepositorio.save(reserva);
    }

    public static double calcularPrecio() {

        Random random = new Random();
        int valor = random.nextInt(10) + 1;
        return valor * PRECIO_NOCHE;
    }

    public void elimnarReservaPorId(Long id) {
        Reserva reservaPorId = reservaRepositorio.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No se encontró la reserva")
        );
        reservaRepositorio.deleteById(reservaPorId.getId());
    }
}
