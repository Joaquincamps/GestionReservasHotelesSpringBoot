package com.example.GestionReservasHotel.modelo;

import com.example.GestionReservasHotel.modelo.enums.habitacion.Estado;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Tipo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int numero;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private int precio;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;

    //metodos helpers
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.setHabitacion(this);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setHabitacion(null);
    }

    public Habitacion() {
    }

    public Habitacion(int numero, Tipo tipo, int precio, Estado estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
        this.reservas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
