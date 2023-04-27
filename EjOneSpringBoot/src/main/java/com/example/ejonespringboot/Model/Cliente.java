package com.example.ejonespringboot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String Nombre;
    private String Apellido;
    private String nombremascota;
    private String Celular;


    public Cliente(Long id, String Nombre, String Apellido, String nombremascota,
                         String Celular) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.nombremascota = nombremascota;
        this.Celular = Celular;
    }

    public Cliente(){}
}

