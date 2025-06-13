package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

	Optional<Ubicacion> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
}