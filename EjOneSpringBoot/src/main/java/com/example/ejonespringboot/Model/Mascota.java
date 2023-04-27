package com.example.ejonespringboot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String Nombre;
    private String Cliente;
    private String Diagnostico;


    public Mascota(Long id, String Nombre, String Cliente, String Diagnostico) {
        this.id = id;
        this.Nombre = Nombre;
        this.Cliente = Cliente;
        this.Diagnostico = Diagnostico;
    }

    public Mascota(){}
}