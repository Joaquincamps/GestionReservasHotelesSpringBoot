package com.example.GestionReservasHotel.repositorio;

import com.example.GestionReservasHotel.modelo.Habitacion;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Estado;
import com.example.GestionReservasHotel.modelo.enums.habitacion.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {

    List<Habitacion> findByEstado(Estado estado);

    List<Habitacion> findByTipo(Tipo tipo);
}
