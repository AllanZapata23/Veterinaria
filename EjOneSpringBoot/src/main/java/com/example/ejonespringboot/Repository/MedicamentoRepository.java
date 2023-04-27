package com.example.ejonespringboot.Repository;

import com.example.ejonespringboot.Model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento,Long>  {
}
