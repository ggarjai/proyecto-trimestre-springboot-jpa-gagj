package com.example.demo.dto.request;



import com.example.demo.model.TipoAlmacen;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UbicacionRequestDTO {

    @NotBlank
    @Size(max = 60)
    private String nombre;

    @NotNull
    private TipoAlmacen tipoAlmacen;

    // Getters y Setters
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
}