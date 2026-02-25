package com.example.GestionReservasHotel.servicio;

import com.example.GestionReservasHotel.modelo.Cliente;
import com.example.GestionReservasHotel.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente {

    private final ClienteRepository clienteRepository;

    public ServicioCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
        clienteRepository.deleteById(id);
    }
}
