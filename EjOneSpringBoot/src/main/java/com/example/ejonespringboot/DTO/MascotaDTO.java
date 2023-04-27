package com.example.ejonespringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {
    Long id;
    private String Nombre;
    private String Cliente;
    private String Diagnostico;
}
