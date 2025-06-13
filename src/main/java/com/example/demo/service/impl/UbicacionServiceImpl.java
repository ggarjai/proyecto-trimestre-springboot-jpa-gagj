package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.request.UbicacionRequestDTO;
import com.example.demo.dto.response.UbicacionResponseDTO;
import com.example.demo.mapper.UbicacionMapper;
import com.example.demo.model.Ubicacion;
import com.example.demo.repository.UbicacionRepository;
import com.example.demo.service.UbicacionService;

@Service
@Transactional
public class UbicacionServiceImpl implements UbicacionService {

	private final UbicacionRepository ubicacionRepository;

	public UbicacionServiceImpl(UbicacionRepository ubicacionRepository) {
		this.ubicacionRepository = ubicacionRepository;
	}

	@Override
	public List<UbicacionResponseDTO> list() {
		List<UbicacionResponseDTO> ubicacionesDTO = new ArrayList<>();
		List<Ubicacion> ubicacionesEntidad = ubicacionRepository.findAll();
		for (Ubicacion ubicacion : ubicacionesEntidad) {
			UbicacionResponseDTO ubicacionResponseDTO = UbicacionMapper.toDTO(ubicacion);
			ubicacionesDTO.add(ubicacionResponseDTO);
		}
		return ubicacionesDTO;

	}

	@Override
	public boolean create(UbicacionRequestDTO ubicacionRequestDTO) {
	    if (ubicacionRepository.existsByNombre(ubicacionRequestDTO.getNombre())) {
	        return false;
	    }

	    Ubicacion ubicacion = UbicacionMapper.toEntity(ubicacionRequestDTO);
	    ubicacionRepository.save(ubicacion);
	    return true;	
		
		
	}

}