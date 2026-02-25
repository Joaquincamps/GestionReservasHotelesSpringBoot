package com.example.GestionReservasHotel.repositorio;

import com.example.GestionReservasHotel.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {
}
