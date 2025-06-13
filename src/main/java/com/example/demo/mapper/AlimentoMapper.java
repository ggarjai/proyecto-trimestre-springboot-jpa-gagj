package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.request.AlimentoRequestDTO;
import com.example.demo.dto.response.AlimentoResponseDTO;
import com.example.demo.model.Alimento;



@Mapper(componentModel = "spring")
public interface AlimentoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    @Mapping(target = "ubicacion", ignore = true)
    Alimento toEntity(AlimentoRequestDTO dto);

    @Mapping(source = "ubicacion.nombre", target = "ubicacion")
    AlimentoResponseDTO toDto(Alimento entity);
}