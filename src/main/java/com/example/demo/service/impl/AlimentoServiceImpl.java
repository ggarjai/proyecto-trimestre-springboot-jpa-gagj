package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.request.AlimentoRequestDTO;
import com.example.demo.dto.response.AlimentoResponseDTO;
import com.example.demo.mapper.AlimentoMapper;
import com.example.demo.model.Alimento;
import com.example.demo.model.Ubicacion;
import com.example.demo.repository.AlimentoRepository;
import com.example.demo.repository.UbicacionRepository;
import com.example.demo.service.AlimentoService;

@Service
@Transactional
public class AlimentoServiceImpl implements AlimentoService {

	private final AlimentoRepository alimentoRepo;
	private final UbicacionRepository ubicacionRepo;
	private final AlimentoMapper mapper;

	public AlimentoServiceImpl(AlimentoRepository alimentoRepo, UbicacionRepository ubicacionRepo,
			AlimentoMapper mapper) {
		this.alimentoRepo = alimentoRepo;
		this.ubicacionRepo = ubicacionRepo;
		this.mapper = mapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlimentoResponseDTO> getAll() {
		return alimentoRepo.findAll()
				.stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public AlimentoResponseDTO getById(Long id) {
		return mapper.toDto(findAlimento(id));
	}

	@Override
	public AlimentoResponseDTO create(AlimentoRequestDTO dto) {
		Alimento entity = mapper.toEntity(dto);
		entity.setUbicacion(findUbicacion(dto.getUbicacionId()));
		alimentoRepo.save(entity);
		return mapper.toDto(entity);
	}

	@Override
	public AlimentoResponseDTO update(Long id, AlimentoRequestDTO dto) {
		Alimento entity = findAlimento(id);
		entity.setNombre(dto.getNombre());
		entity.setCantidad(dto.getCantidad());
		entity.setPerecedero(dto.isPerecedero());
		entity.setFechaCaducidad(dto.getFechaCaducidad());
		entity.setUbicacion(findUbicacion(dto.getUbicacionId()));
		return mapper.toDto(entity);
	}

	@Override
	public void delete(Long id) {
		alimentoRepo.delete(findAlimento(id));
	}

	@Override
	public void moverAlimento(Long alimentoId, Long nuevaUbicacionId) {
		Alimento alimento = findAlimento(alimentoId);
		alimento.setUbicacion(findUbicacion(nuevaUbicacionId));
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlimentoResponseDTO> proximosACaducar(int dias) {
		LocalDate limite = LocalDate.now().plusDays(dias);
		return alimentoRepo.findByFechaCaducidadBefore(limite)
				.stream()
				.sorted(Comparator.comparing(Alimento::getFechaCaducidad))
				.map(mapper::toDto)
				.collect(Collectors.toList());
	}

	/* ---------- helpers ---------- */

	private Alimento findAlimento(Long id) {
		return alimentoRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alimento no encontrado: " + id));
	}

	private Ubicacion findUbicacion(Long id) {
		return ubicacionRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Ubicación no encontrada: " + id));
	}
}