package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.AlimentoRequestDTO;
import com.example.demo.dto.response.AlimentoResponseDTO;
import com.example.demo.service.AlimentoService;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoRestController {

	private final AlimentoService service;

	public AlimentoRestController(AlimentoService service) {
		this.service = service;
	}

	@GetMapping
	public List<AlimentoResponseDTO> list() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public AlimentoResponseDTO detail(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AlimentoResponseDTO create(@Validated @RequestBody AlimentoRequestDTO dto) {
		return service.create(dto);
	}

	@PutMapping("/{id}")
	public AlimentoResponseDTO update(@PathVariable Long id,
			@Validated @RequestBody AlimentoRequestDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}