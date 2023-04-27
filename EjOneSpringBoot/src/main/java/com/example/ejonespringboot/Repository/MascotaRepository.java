package com.example.ejonespringboot.Repository;

import com.example.ejonespringboot.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long>  {
}
