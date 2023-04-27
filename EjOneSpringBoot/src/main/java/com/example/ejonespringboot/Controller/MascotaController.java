package com.example.ejonespringboot.Controller;

import com.example.ejonespringboot.Model.Mascota;
import com.example.ejonespringboot.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public String getAllMascota(Model model) {
        model.addAttribute("mascotas",mascotaService.getAllMascota());
        model.addAttribute("mascota", new Mascota());
        return "mascota";
    }

    @GetMapping("/{id}")
    public String getMascotaId(@PathVariable Long id, Model model) {
        Optional<Mascota> mascota = mascotaService.getMascotaById(id);
        if (mascota.isPresent()) {
            model.addAttribute("mascota", mascota.get());
            return "mascota";
        } else {
            return "error";
        }
    }

    @PostMapping
    public String addMascota(Mascota mascota) {
        mascotaService.addMascota(mascota);
        return "redirect:/mascota";
    }

    @PutMapping("/{id}")
    public String updateMascota(@PathVariable Long id, @ModelAttribute("mascota") Mascota mascota) {
        Optional<Mascota> existingMascota = mascotaService.getMascotaById(id);
        if (existingMascota.isPresent()) {
          mascotaService.updateMascota(id, mascota);
            return "redirect:/mascota/{id}";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteMascota(@PathVariable Long id) {
        Optional<Mascota> existingMascota = mascotaService.getMascotaById(id);
        if (existingMascota.isPresent()) {
            mascotaService.deleteMascota(id);
            return "redirect:/mascota";
        } else {
            return "error";
        }
    }
}
