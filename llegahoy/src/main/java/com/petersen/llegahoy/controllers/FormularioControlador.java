package com.petersen.llegahoy.controllers;

import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.entidades.FormularioDTO;
import com.petersen.llegahoy.services.iFormularioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/formulario"})
public class FormularioControlador {

    private final iFormularioService servicio;

    public FormularioControlador(iFormularioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/personas")
    @ApiOperation("Muestra todos los formularios cargados en la base de datos")
    @ApiResponse(code = 200, message = "OK")
    public List<FormularioDTO> mostrarFormularios() {
        List <FormularioDTO> formulariosCargados = servicio.mostrarTodosLosFormularios();
        return formulariosCargados;
    }

    @GetMapping("/personas/{id}")
    @ApiOperation("Muestra un formulario buscándolo por su ID")
    @ApiResponse(code = 200, message = "OK")
    public Optional<FormularioDTO> mostrarFormularioPorID(@PathVariable Long id) {
        return servicio.mostrarFormularioPorID(id);
    }

    @GetMapping("/personas/mail/{mail}")
    @ApiOperation("Muestra un formulario buscándolo por su email")
    @ApiResponse(code = 200, message = "OK")
    public Optional<FormularioDTO> mostrarFormularioPorID(@PathVariable String mail) {
        return servicio.mostrarFormularioPorMail(mail);
    }

    @PostMapping("/personas")
    @ApiOperation("Guarda un formulario hecho por el usuario en la base de datos")
    @ApiResponse(code = 201, message = "Creado")
    public FormularioDTO nuevoFormulario(@RequestBody FormularioDTO formularioDTO) {
        return servicio.cargarNuevoFormulario(formularioDTO);
    }

    // este método sirve para mostrar todos los formularios enviados y ya guardados en la base de datos
//    @GetMapping("/personas")
//    @ApiOperation("Muestra todos los formularios cargados en la base de datos")
//    @ApiResponse(code = 200, message = "OK")
//    public List<FormularioDTO> mostrarFormularios() {
//        List <FormularioDTO> formulariosCargados = servicio.mostrarTodosLosFormularios();
//        return formulariosCargados;
//    }
//
//    @GetMapping("/personas/{id}")
//    @ApiOperation("Muestra un formulario buscándolo por su ID")
//    @ApiResponse(code = 200, message = "OK")
//    public List<FormularioDTO> mostrarFormularioPorID(@PathVariable Long id) {
//        return servicio.mostrarFormularioPorID(id);
//    }

    // este método sirve para que un usuario pueda enviar y guardar un formulario
//    @PostMapping("/personas")
//    @ApiOperation("Guarda un formulario hecho por el usuario en la base de datos")
//    @ApiResponse(code = 201, message = "Creado")
//    public FormularioDTO nuevoFormulario(@RequestBody FormularioDTO form) {
//        return servicio.cargarNuevoFormulario(form);
//    }

}
