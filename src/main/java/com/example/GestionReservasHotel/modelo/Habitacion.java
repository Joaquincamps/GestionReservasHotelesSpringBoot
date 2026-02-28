package com.example.GestionReservasHotel.modelo;

import com.example.GestionReservasHotel.modelo.enums.Estado;
import com.example.GestionReservasHotel.modelo.enums.Tipo;
import jakarta.persistence.*;

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

    public Habitacion() {
    }

    public Habitacion(int numero, Tipo tipo, int precio, Estado estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
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
}
