package com.example.ejonespringboot.Service;

import com.example.ejonespringboot.Model.Medico;
import com.example.ejonespringboot.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public List<Medico> getAllMedico() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> getMedicoById(Long id) {
        return medicoRepository.findById(id);
    }

    public void addMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    public void updateMedico(Long id, Medico medico) {
        medico.setId(id);
        medicoRepository.save(medico);
    }

    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
