package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.UbicacionRequestDTO;
import com.example.demo.dto.response.UbicacionResponseDTO;
import com.example.demo.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

	@Autowired
	private UbicacionService ubicacionService;

	@GetMapping
	public List<UbicacionResponseDTO> list() {
		return ubicacionService.list();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody UbicacionRequestDTO ubicacionRequestDTO) {
		boolean creada = ubicacionService.create(ubicacionRequestDTO);

		if (!creada) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de la ubicación ya está en uso.");
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}