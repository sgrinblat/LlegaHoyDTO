package com.petersen.llegahoy.services;

import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.entidades.FormularioDTO;

import java.util.List;
import java.util.Optional;

public interface iFormularioService {


    List<FormularioDTO> mostrarTodosLosFormularios();

    Optional<FormularioDTO> mostrarFormularioPorID(Long id);

    Optional<FormularioDTO> mostrarFormularioPorMail(String mail);

    FormularioDTO cargarNuevoFormulario(FormularioDTO formularioDTO);
}
