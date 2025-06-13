package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.UbicacionRequestDTO;
import com.example.demo.dto.response.UbicacionResponseDTO;

public interface UbicacionService {
	public List<UbicacionResponseDTO> list();

	public boolean create(UbicacionRequestDTO ubicacionRequestDTO);

}
