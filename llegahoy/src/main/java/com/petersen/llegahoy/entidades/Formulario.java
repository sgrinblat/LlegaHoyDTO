package com.petersen.llegahoy.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "formulario")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Formulario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formulario;

    @Column(name = "nombre_formulario")
    private String nombreFormulario;

    @Column(name = "apellido_formulario")
    private String apellidoFormulario;

    @Column(name = "email_formulario")
    private String emailFormulario;

    @Column(name = "mensaje_formulario")
    private String mensajeFormulario;

    public Long getId_formulario() {
        return id_formulario;
    }

}
