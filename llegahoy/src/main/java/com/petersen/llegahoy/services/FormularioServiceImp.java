package com.petersen.llegahoy.services;

import com.petersen.llegahoy.Mapper.FormularioMapper;
import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.entidades.FormularioDTO;
import com.petersen.llegahoy.repositories.iFormularioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormularioServiceImp implements iFormularioService {

    @Autowired
    private iFormularioRepo iFormularioRepo;

    @Autowired
    private FormularioMapper mapper;

    @Override
    public List<FormularioDTO> mostrarTodosLosFormularios() {
        List<Formulario> formularios = (List<Formulario>) iFormularioRepo.findAll();
        return mapper.toFormularios(formularios);
    }

    @Override
    public Optional<FormularioDTO> mostrarFormularioPorID(Long id) {
        return iFormularioRepo.findById(id).map(formulario -> mapper.toFormularioDTO(formulario));
    }

    @Override
    public Optional<FormularioDTO> mostrarFormularioPorMail(String mail) {
        return iFormularioRepo.findByEmailFormulario(mail).map(formulario -> mapper.toFormularioDTO(formulario));
    }

    @Override
    public FormularioDTO cargarNuevoFormulario(@RequestBody FormularioDTO formularioDTO) {
        Formulario formulario = mapper.toFormulario(formularioDTO);
        return mapper.toFormularioDTO(iFormularioRepo.save(formulario));
    }



//    @Override
//    public List<FormularioDTO> mostrarTodosLosFormularios() {
//        return ((List<Formulario>) iFormularioRepo
//                .findAll())
//                .stream()
//                .map(this::mapearFormularioDTO)
//                    .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<FormularioDTO> mostrarFormularioPorID(Long id) {
//        return ((Optional<Formulario>) iFormularioRepo
//                .findById(id))
//                .stream()
//                .map(this::mapearFormularioDTO)
//                .collect(Collectors.toList());
//    }
//
////    @Override
////    public FormularioDTO cargarNuevoFormulario(@RequestBody Formulario formularioLlenado) {
////        FormularioDTO formulario = mapearFormularioDTO(formularioLlenado);
////        return iFormularioRepo.save(formulario);
////
////    }
//
//    private FormularioDTO mapearFormularioDTO(Formulario formulario) {
//        FormularioDTO formularioDTO = new FormularioDTO();
//        formularioDTO.setIdForm(formulario.getId_formulario());
//        formularioDTO.setNameForm(formulario.getNombreFormulario());
//        formularioDTO.setLastnameForm(formulario.getApellidoFormulario());
//        formularioDTO.setMailForm(formulario.getEmailFormulario());
//        formularioDTO.setMessageForm(formulario.getMensajeFormulario());
//        return formularioDTO;
//    }
}
