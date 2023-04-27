package com.example.ejonespringboot.Service;

import com.example.ejonespringboot.Model.Administrador;
import com.example.ejonespringboot.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AdministradorService {
    @Autowired
    AdministradorRepository administradorRepository;

    public List<Administrador> getAllAdministrador() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> getAdministradorById(Long id) {
        return administradorRepository.findById(id);
    }

    public void addAdministrador(Administrador administrador) {
       administradorRepository.save(administrador);
    }

    public void updateAdministrador(Long id, Administrador administrador) {
        administrador.setId(id);
        administradorRepository.save(administrador);
    }

    public void deleteAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}

