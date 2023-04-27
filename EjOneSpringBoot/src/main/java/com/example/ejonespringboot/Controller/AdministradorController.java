package com.example.ejonespringboot.Controller;

import com.example.ejonespringboot.Model.Administrador;
import com.example.ejonespringboot.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public String getAllAdministrador(Model model) {
        List<Administrador> administradores = administradorService.getAllAdministrador();
        model.addAttribute("administradores", administradores);
        model.addAttribute("administrador", new Administrador());
        return "administrador";
    }

    @GetMapping("/{id}")
    public String getAdministradorById(@PathVariable Long id, Model model) {
        Optional<Administrador> administrador = administradorService.getAdministradorById(id);
        if (administrador.isPresent()) {
            model.addAttribute("administrador", administrador.get());
            return "administrador";
        } else {
            return "error";
        }
    }

    @PostMapping
    public String addAdministrador(Administrador administrador) {
        administradorService.addAdministrador(administrador);
        return "redirect:/administrador";
    }

    @PutMapping("/{id}")
    public String updateAdministrador(@PathVariable Long id, @ModelAttribute("administrador") Administrador administrador) {
        Optional<Administrador> existingAdministrador = administradorService.getAdministradorById(id);
        if (existingAdministrador.isPresent()) {
            administradorService.updateAdministrador(id, administrador);
            return "redirect:/administrador/{id}";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAdministrador(@PathVariable Long id) {
        Optional<Administrador> existingAdministrador = administradorService.getAdministradorById(id);
        if (existingAdministrador.isPresent()) {
            administradorService.deleteAdministrador(id);
            return "redirect:/administrador";
        } else {
            return "error";
 }
}
}
