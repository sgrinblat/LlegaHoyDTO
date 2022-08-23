package com.petersen.llegahoy.Mapper;

import com.petersen.llegahoy.entidades.Usuario;
import com.petersen.llegahoy.entidades.UsuarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "username", target = "registerUsername"),
            @Mapping(source = "userPassword", target = "registerPassword"),
    })
    UsuarioDTO toUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> toUsuarios(List<Usuario> usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(UsuarioDTO usuarioDTO);
}
