package com.example.GestionReservasHotel.servicio;

import com.example.GestionReservasHotel.modelo.Cliente;
import com.example.GestionReservasHotel.modelo.Reserva;
import com.example.GestionReservasHotel.modelo.enums.gestionReservas.EstadoReservas;
import com.example.GestionReservasHotel.repositorio.ClienteRepository;
import com.example.GestionReservasHotel.repositorio.ReservaRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente {

    private final ClienteRepository clienteRepository;

    private final ReservaRepositorio reservaRepositorio;

    public ServicioCliente(ClienteRepository clienteRepository, ReservaRepositorio reservaRepositorio) {
        this.clienteRepository = clienteRepository;
        this.reservaRepositorio = reservaRepositorio;
    }

    public Cliente crearCLiente(Cliente cliente) {
        char[] LETRAS_DNI = {
                'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                'C', 'K', 'E'
        };
        int numerosDni = Integer.parseInt(cliente.getDni().substring(0, 8));
        char letraCalculada = LETRAS_DNI[numerosDni % 23];
        char letraIntroducida = Character.toUpperCase(cliente.getDni().charAt(8));
        if (letraCalculada != letraIntroducida) {
            throw new IllegalArgumentException("Dni inválido");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void borrarCliente(Long id) {

        Cliente buscarCliente = clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente no encontrado.")
        );

        boolean encontrado = false;

        List<Reserva> listaReservas = reservaRepositorio.findAll();
        for (Reserva reserva : listaReservas) {
            if(reserva.getCliente().equals(buscarCliente)){
                if(reserva.getEstado().equals(EstadoReservas.ACTIVA)){
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            throw new IllegalStateException("No se puede eliminar un cliente con una reserva activa");
        } else {
            clienteRepository.deleteById(id);
        }
    }
}
