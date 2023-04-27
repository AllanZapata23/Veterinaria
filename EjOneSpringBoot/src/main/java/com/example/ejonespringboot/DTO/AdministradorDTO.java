package com.example.ejonespringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorDTO {
    Long id;
    private String Nombre;
    private String Apellido;
    private String Celular;
    private String Usuario;
    private String Contrasena;
}
