package com.example.ejonespringboot.Controller;

import com.example.ejonespringboot.Model.Medico;
import com.example.ejonespringboot.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String getAllMedico(Model model) {
        List<Medico> medicos = medicoService.getAllMedico();
        model.addAttribute("medicos", medicos);
        model.addAttribute("medico", new Medico());
        return "medico";
    }

    @GetMapping("/{id}")
    public String getMedicoId(@PathVariable Long id, Model model) {
        Optional<Medico> medico = medicoService.getMedicoById(id);
        if (medico.isPresent()) {
            model.addAttribute("medico", medico.get());
            return "mascota";
        } else {
            return "error";
        }
    }

    @PostMapping
    public String addMedico(Medico medico) {
        medicoService.addMedico(medico);
        return "redirect:/medico";
    }

    @PutMapping("/{id}")
    public String updateMedico(@PathVariable Long id, @ModelAttribute("medico") Medico medico) {
        Optional<Medico> existingMedico = medicoService.getMedicoById(id);
        if (existingMedico.isPresent()) {
            medicoService.updateMedico(id, medico);
            return "redirect:/medico/{id}";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteMedico(@PathVariable Long id) {
        Optional<Medico> existingMedico = medicoService.getMedicoById(id);
        if (existingMedico.isPresent()) {
            medicoService.deleteMedico(id);
            return "redirect:/medico";
        } else {
            return "error";
        }
    }
}
