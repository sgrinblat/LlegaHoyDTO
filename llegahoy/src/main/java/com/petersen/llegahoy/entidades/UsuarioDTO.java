package com.petersen.llegahoy.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UsuarioDTO {
    private String registerUsername;
    private String registerPassword;
}
