package com.example.ejonespringboot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String Nombre;
    private String Apellido;
    private String mascotaacargo;

    public Medico(Long id, String Nombre, String Apellido, String mascotaacargo) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.mascotaacargo = mascotaacargo;
    }

    public Medico(){}
}
