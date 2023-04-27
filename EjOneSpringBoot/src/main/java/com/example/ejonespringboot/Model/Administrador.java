package com.example.ejonespringboot.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String Nombre;
    private String Apellido;
    private String Celular;
    private String Usuario;
    private String Contrasena;


    public Administrador(Long id, String Nombre, String Apellido, String Celular,
                   String Usuario, String Contrasena) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public Administrador(){}
}
