package com.example.demo.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AlimentoResponseDTO {

	private Long id;
	private String nombre;
	private boolean perecedero;
	private LocalDate fechaCaducidad;
	private Integer cantidad;
	private String ubicacion;
	private Long ubicacionId;
}