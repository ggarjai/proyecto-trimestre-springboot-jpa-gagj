package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.model.TipoAlmacen;

public class UbicacionResponseDTO {

    private Long id;
    private String nombre;
    private TipoAlmacen tipoAlmacen;
    private List<AlimentoResponseDTO> alimentos;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAlmacen getTipoAlmacen() {
        return tipoAlmacen;
    }

    public void setTipoAlmacen(TipoAlmacen tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }

    public List<AlimentoResponseDTO> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<AlimentoResponseDTO> alimentos) {
        this.alimentos = alimentos;
    }
}