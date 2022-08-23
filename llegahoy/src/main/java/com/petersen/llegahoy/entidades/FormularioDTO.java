package com.petersen.llegahoy.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FormularioDTO {
    private Long idForm;
    private String nameForm;
    private String lastnameForm;
    private String mailForm;
    private String messageForm;

}
