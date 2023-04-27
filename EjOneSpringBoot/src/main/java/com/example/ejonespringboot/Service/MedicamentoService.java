package com.example.ejonespringboot.Service;

import com.example.ejonespringboot.Model.Medicamento;
import com.example.ejonespringboot.Repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MedicamentoService {
    @Autowired
    MedicamentoRepository medicamentoRepository;

    public List<Medicamento> getAllMedicamento() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> getMedicamentoById(Long id) {
        return medicamentoRepository.findById(id);
    }

    public void addMedicamento(Medicamento medicamento) {
        medicamentoRepository.save(medicamento);
    }

    public void updateMedicamento(Long id, Medicamento medicamento) {
        medicamento.setId(id);
        medicamentoRepository.save(medicamento);
    }

    public void deleteMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }
}
