package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Alimento;
import com.example.demo.model.Ubicacion;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

	List<Alimento> findByUbicacion(Ubicacion ubicacion);

	List<Alimento> findByFechaCaducidadBefore(LocalDate fecha);
}