package com.example.GestionReservasHotel.repositorio;

import com.example.GestionReservasHotel.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva,Long> {
}
