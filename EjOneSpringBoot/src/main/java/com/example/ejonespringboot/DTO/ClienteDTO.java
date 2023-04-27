package com.example.ejonespringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    Long id;
    private String Nombre;
    private String Apellido;
    private String nombremascota;
    private String Celular;
}
