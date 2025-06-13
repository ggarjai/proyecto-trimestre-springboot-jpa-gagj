package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.AlimentoRequestDTO;
import com.example.demo.dto.response.AlimentoResponseDTO;

public interface AlimentoService {

	List<AlimentoResponseDTO> getAll();

	AlimentoResponseDTO getById(Long id);

	AlimentoResponseDTO create(AlimentoRequestDTO dto);

	AlimentoResponseDTO update(Long id, AlimentoRequestDTO dto);

	void delete(Long id);

	void moverAlimento(Long alimentoId, Long nuevaUbicacionId);

	List<AlimentoResponseDTO> proximosACaducar(int dias);
}