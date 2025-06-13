package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.request.UbicacionRequestDTO;
import com.example.demo.dto.response.AlimentoResponseDTO;
import com.example.demo.dto.response.UbicacionResponseDTO;
import com.example.demo.model.Alimento;
import com.example.demo.model.Ubicacion;

public interface UbicacionMapper {

	public static Ubicacion toEntity(UbicacionRequestDTO dto) {
		Ubicacion ubicacion = new Ubicacion();
		ubicacion.setNombre(dto.getNombre());
		ubicacion.setTipoAlmacen(dto.getTipoAlmacen());
		return ubicacion;
	}

	public static UbicacionResponseDTO toDTO(Ubicacion ubicacion) {
		UbicacionResponseDTO dto = new UbicacionResponseDTO();
		dto.setId(ubicacion.getId());
		dto.setNombre(ubicacion.getNombre());
		dto.setTipoAlmacen(ubicacion.getTipoAlmacen());

		List<AlimentoResponseDTO> alimentos = ubicacion.getAlimentos().stream().map(UbicacionMapper::toAlimentoDTO)
				.collect(Collectors.toList());

		dto.setAlimentos(alimentos);
		return dto;
	}

	private static AlimentoResponseDTO toAlimentoDTO(Alimento alimento) {
		AlimentoResponseDTO dto = new AlimentoResponseDTO();
		dto.setId(alimento.getId());
		dto.setNombre(alimento.getNombre());
		dto.setPerecedero(alimento.isPerecedero());
		dto.setFechaCaducidad(alimento.getFechaCaducidad());
		dto.setCantidad(alimento.getCantidad());
		return dto;
	}
}