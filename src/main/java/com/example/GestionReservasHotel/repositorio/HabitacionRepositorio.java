package com.example.GestionReservasHotel.repositorio;

import com.example.GestionReservasHotel.dto.habitacion.DtoFiltrarPorEstado;
import com.example.GestionReservasHotel.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {

    List<DtoFiltrarPorEstado> listarPorEstado();
}
