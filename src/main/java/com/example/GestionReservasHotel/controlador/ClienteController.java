package com.example.GestionReservasHotel.controlador;

import com.example.GestionReservasHotel.modelo.Cliente;
import com.example.GestionReservasHotel.repositorio.ClienteRepository;
import com.example.GestionReservasHotel.servicio.ServicioCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ServicioCliente servicioCliente;

    public ClienteController(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteCreado = servicioCliente.crearCLiente(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<Cliente> listarCliente() {
        return servicioCliente.listarClientes();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> clientePorId = servicioCliente.buscarPorId(id);
        return ResponseEntity.ok(clientePorId.get());
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        servicioCliente.borrarCliente(id);
        return ResponseEntity.ok("Cliente eliminado");
    }
}
