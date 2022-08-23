package com.petersen.llegahoy.Mapper;

import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.entidades.FormularioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormularioMapper {
    @Mappings({
            @Mapping(source = "id_formulario", target = "idForm"),
            @Mapping(source = "nombreFormulario", target = "nameForm"),
            @Mapping(source = "apellidoFormulario", target = "lastnameForm"),
            @Mapping(source = "emailFormulario", target = "mailForm"),
            @Mapping(source = "mensajeFormulario", target = "messageForm")
    })
    FormularioDTO toFormularioDTO(Formulario formulario);

    List<FormularioDTO> toFormularios(List<Formulario> formularios);

    @InheritInverseConfiguration
    Formulario toFormulario(FormularioDTO formularioDTO);
}
