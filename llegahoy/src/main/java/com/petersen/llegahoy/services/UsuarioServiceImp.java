package com.petersen.llegahoy.services;

import com.petersen.llegahoy.Mapper.UsuarioMapper;
import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.entidades.Usuario;
import com.petersen.llegahoy.entidades.UsuarioDTO;
import com.petersen.llegahoy.repositories.iUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements iUsuarioService {

    @Autowired
    private iUsuarioRepo iUsuarioRepo;

    @Autowired
    private UsuarioMapper mapper;

    @Override
    public List<UsuarioDTO> mostrarUsuarios() {
        List<Usuario> usuarios = (List<Usuario>) iUsuarioRepo.findAll();
        return mapper.toUsuarios(usuarios);
    }

    @Override
    public Optional<UsuarioDTO> loguearUsuario(UsuarioDTO usuarioDTO) {
        return iUsuarioRepo.findById(usuarioDTO.getRegisterUsername()).map(usuario -> mapper.toUsuarioDTO(usuario));
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.toUsuario(usuarioDTO);
        return mapper.toUsuarioDTO(iUsuarioRepo.save(usuario));
    }

    @Override
    public void eliminarUsuario(String registerUsername) {
        iUsuarioRepo.deleteById(registerUsername);
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.toUsuario(usuarioDTO);
        return mapper.toUsuarioDTO(iUsuarioRepo.save(usuario));
    }

//    @Autowired
//    private iUsuarioRepo iUsuarioRepo;
//
//    @Override
//    public List<Usuario> mostrarUsuarios() {
//        return iUsuarioRepo.findAll();
//    }
//
//    @Override
//    public Optional<Usuario> loguearUsuario(Usuario user) {
//        return iUsuarioRepo.findById(user.getUsername());
//    }
//
//    @Override
//    public Usuario registrarUsuario(@RequestBody Usuario userRegistrado) {
//        return iUsuarioRepo.save(userRegistrado);
//    }
//
//    @Override
//    public void eliminarUsuario(Usuario user) {
//        iUsuarioRepo.delete(user);
//    }
//
//    @Override
//    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizado) {
//        return iUsuarioRepo.save(usuarioActualizado);
//    }

}
