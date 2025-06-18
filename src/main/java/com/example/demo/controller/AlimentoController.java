package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.AlimentoRequestDTO;
import com.example.demo.dto.response.AlimentoResponseDTO;
import com.example.demo.model.Alimento;
import com.example.demo.service.AlimentoService;
import com.example.demo.service.UbicacionService;

@Controller
@RequestMapping("/alimentos")
public class AlimentoController {

    private final AlimentoService alimentoService;
    private final UbicacionService ubicacionService;

    public AlimentoController(AlimentoService alimentoService, UbicacionService ubicacionService) {
        this.alimentoService = alimentoService;
        this.ubicacionService = ubicacionService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alimentos", alimentoService.getAll());
        return "alimentos/list";
    }
    
    @GetMapping("/crear")
    public String crearForm(Model model) {
        model.addAttribute("alimento", new AlimentoRequestDTO());
        model.addAttribute("ubicaciones", ubicacionService.list());
        return "alimentos/form";
    }
    @PostMapping("/crear")
    public String crear(@ModelAttribute AlimentoRequestDTO dto) {
    	alimentoService.create(dto);
        return "redirect:/alimentos";
    }

    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        AlimentoResponseDTO alimento = alimentoService.getById(id);

        AlimentoRequestDTO dto = new AlimentoRequestDTO();
        dto.setId(alimento.getId());
        dto.setNombre(alimento.getNombre());
        dto.setCantidad(alimento.getCantidad());
        dto.setPerecedero(alimento.isPerecedero());
        dto.setFechaCaducidad(alimento.getFechaCaducidad());
        dto.setUbicacionId(alimento.getUbicacionId());

        model.addAttribute("alimento", dto);
        model.addAttribute("ubicaciones", ubicacionService.list());
        return "alimentos/form";
    }
    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @ModelAttribute AlimentoRequestDTO dto) {
    	alimentoService.update(id, dto);
        return "redirect:/alimentos";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
    	alimentoService.delete(id);
        return "redirect:/alimentos";
    }
}