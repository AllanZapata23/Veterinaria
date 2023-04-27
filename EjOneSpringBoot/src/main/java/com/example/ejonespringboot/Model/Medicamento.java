package com.example.ejonespringboot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String Nombre;
    private String Precio;


    public Medicamento(Long id, String Nombre, String Precio) {
        this.id = id;
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    public Medicamento(){}
}
