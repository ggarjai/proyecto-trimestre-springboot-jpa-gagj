package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 60, unique = true)
	private String nombre; // p. ej. “Alacena-1”, “Nevera-Puerta”

	@Enumerated(EnumType.STRING)
	private TipoAlmacen tipoAlmacen;

	@OneToMany(mappedBy = "ubicacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alimento> alimentos = new ArrayList<>();
}