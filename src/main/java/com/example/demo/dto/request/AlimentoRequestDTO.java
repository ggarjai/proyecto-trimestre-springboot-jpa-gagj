package com.example.demo.dto.request;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AlimentoRequestDTO {

	@NotBlank
	@Size(max = 120)
	private String nombre;

	private boolean perecedero;

	private LocalDate fechaCaducidad;

	@Positive
	private Integer cantidad;

	@NotNull
	private Long ubicacionId;

	public boolean isPerecedero() {
		return perecedero;
	}

	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Long getUbicacionId() {
		return ubicacionId;
	}

}