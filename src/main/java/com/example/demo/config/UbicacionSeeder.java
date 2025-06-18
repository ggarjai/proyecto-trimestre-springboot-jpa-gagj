package com.example.demo.config;

import com.example.demo.model.TipoAlmacen;
import com.example.demo.model.Ubicacion;
import com.example.demo.repository.UbicacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class UbicacionSeeder implements CommandLineRunner {

    private final UbicacionRepository ubicacionRepository;
    private final Random random = new Random();

    public UbicacionSeeder(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    @Override
    public void run(String... args) {
        if (ubicacionRepository.count() == 0) {
            List<String> nombres = List.of("Nevera-Puerta", "Alacena-1", "Despensa-Baja", "Congelador", "Estante-3");
            TipoAlmacen[] tipos = TipoAlmacen.values();

            for (int i = 0; i < 5; i++) {
                Ubicacion u = new Ubicacion();
                u.setNombre(nombres.get(i));
                u.setTipoAlmacen(tipos[random.nextInt(tipos.length)]);
                ubicacionRepository.save(u);
            }

            System.out.println("Ubicaciones generadas automáticamente.");
        }
    }
}
