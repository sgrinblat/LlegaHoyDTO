package com.petersen.llegahoy.services;

import com.petersen.llegahoy.entidades.Usuario;
import com.petersen.llegahoy.entidades.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface iUsuarioService {

    List<UsuarioDTO> mostrarUsuarios();

    Optional <UsuarioDTO> loguearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);

    public void eliminarUsuario(String registerUsername);

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);
}
