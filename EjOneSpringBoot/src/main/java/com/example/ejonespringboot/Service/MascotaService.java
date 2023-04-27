package com.example.ejonespringboot.Service;

import com.example.ejonespringboot.Model.Mascota;
import com.example.ejonespringboot.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMascota() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> getMascotaById(Long id) {
        return mascotaRepository.findById(id);
    }

    public void addMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    public void updateMascota(Long id, Mascota mascota) {
        mascota.setId(id);
       mascotaRepository.save(mascota);
    }

    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
