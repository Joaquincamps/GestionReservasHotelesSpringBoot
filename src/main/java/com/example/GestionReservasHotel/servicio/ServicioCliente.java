package com.example.GestionReservasHotel.servicio;

import com.example.GestionReservasHotel.modelo.Cliente;
import com.example.GestionReservasHotel.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCliente {

    private final ClienteRepository clienteRepository;

    public ServicioCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCLiente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
