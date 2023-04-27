package com.example.ejonespringboot.Controller;

import com.example.ejonespringboot.Model.Medicamento;
import com.example.ejonespringboot.Service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public String getAllMedicamento(Model model) {
        List<Medicamento> medicamentos = medicamentoService.getAllMedicamento();
        model.addAttribute("medicamentos", medicamentos);
        model.addAttribute("medicamento", new Medicamento());
        return "medicamento";
    }

    @GetMapping("/{id}")
    public String getMedicamentoId(@PathVariable Long id, Model model) {
        Optional<Medicamento> medicamento = medicamentoService.getMedicamentoById(id);
        if (medicamento.isPresent()) {
            model.addAttribute("medicamento", medicamento.get());
            return "medicamento";
        } else {
            return "error";
        }
    }

    @PostMapping
    public String addMedicamento(Medicamento medicamento) {
        medicamentoService.addMedicamento(medicamento);
        return "redirect:/medicamento";
    }

    @PutMapping("/{id}")
    public String updateMedicamento(@PathVariable Long id, @ModelAttribute("medicamento") Medicamento medicamento) {
        Optional<Medicamento> existingMedicamento = medicamentoService.getMedicamentoById(id);
        if (existingMedicamento.isPresent()) {
            medicamentoService.updateMedicamento(id, medicamento);
            return "redirect:/medicamento/{id}";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteMedicamento(@PathVariable Long id) {
        Optional<Medicamento> existingMedicamento = medicamentoService.getMedicamentoById(id);
        if (existingMedicamento.isPresent()) {
           medicamentoService.deleteMedicamento(id);
            return "redirect:/mascota";
        } else {
            return "error";
        }
    }
}
