package com.petersen.llegahoy.controllers;

import com.petersen.llegahoy.entidades.Usuario;
import com.petersen.llegahoy.entidades.UsuarioDTO;
import com.petersen.llegahoy.services.iUsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UsuarioControlador {

    @Autowired
    private final iUsuarioService servicio;

    public UsuarioControlador(iUsuarioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/personas")
    @ApiOperation("Muestra todos los usuarios registrados en la base de datos")
    @ApiResponse(code = 200, message = "OK")
    public List<UsuarioDTO> mostrarTodosUsuarios() {
        return servicio.mostrarUsuarios();
    }

    // método para ingresar al sistema con un usuario previamente registrado
    @PostMapping("/personas")
    @ApiOperation("Permite a un usuario loguearse en el sistema si se encuentra registrado previamente en la base de datos")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity <?> loginUser(@RequestBody UsuarioDTO userData) {

        Map<String, Object> mensajeBody = new HashMap<>();

        Optional <UsuarioDTO> user = servicio.loguearUsuario(userData);
        if(user.get().getRegisterPassword().equals(userData.getRegisterPassword())) {
            mensajeBody.put("mensaje", "El usuario pudo loguearse correctamente.");
            return ResponseEntity.ok().body(mensajeBody);
        } else {
            mensajeBody.put("mensaje", "El usuario no se encuentra registrado.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
    }

    // método para registrar un usuario nuevo, comprobando antes si el username no existe en la base de datos
    @RequestMapping(value = "/registros", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("Registra un usuario nuevo en la base datos, comprobando previamente si no se encuentra el username ya registrado")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario registrado exitosamente"),
            @ApiResponse(code = 400, message = "El Usuario ya se encuentra registrado")
    })
    public void registrarNuevoUsuario(@RequestBody UsuarioDTO userData) throws Exception {
        Optional <UsuarioDTO> user = servicio.loguearUsuario(userData);
        if(user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ingresado ya existe!");
        } else {
            servicio.registrarUsuario(userData);
        }
    }

    // método para eliminar un usuario registrado en la base de datos
    @DeleteMapping("/personas")
    @ApiOperation("Elimina un usuario de la base datos, comprobando previamente si se encuentra registrado")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario eliminado exitosamente"),
            @ApiResponse(code = 404, message = "El usuario que se desea eliminar no existe")
    })
    public void eliminarUsuario(@RequestBody UsuarioDTO userData) {
        Optional <UsuarioDTO> user = servicio.loguearUsuario(userData);
        if(user.isPresent()){
            servicio.eliminarUsuario(user.get().getRegisterUsername());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario que se desea eliminar no existe.");
        }
    }

     // método para actualizar un usuario registrado en la base de datos (puede cambiarle la password)
    @PutMapping("/personas")
    @ResponseBody
    @ApiOperation("Actualiza la contraseña de un usuario de la base datos, comprobando previamente si se encuentra registrado")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario actualizado exitosamente"),
            @ApiResponse(code = 404, message = "El usuario que se desea actualizar no existe")
    })
    public void actualizarUsuario(@RequestBody UsuarioDTO userData) throws Exception {
        Optional <UsuarioDTO> user = servicio.loguearUsuario(userData);
        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario ingresado para actualizar no existe!");
        } else {
            servicio.actualizarUsuario(userData);
        }
    }


    // método con el cual podemos listar los usuarios registrados en el sistema
//    @GetMapping("/personas")
//    @ApiOperation("Muestra todos los usuarios registrados en la base de datos")
//    @ApiResponse(code = 200, message = "OK")
//    public List<Usuario> mostrarTodosUsuarios() {
//        return servicio.mostrarUsuarios();
//    }
//
//    // método para ingresar al sistema con un usuario previamente registrado
//    @PostMapping("/personas")
//    @ApiOperation("Permite a un usuario loguearse en el sistema si se encuentra registrado previamente en la base de datos")
//    @ApiResponse(code = 200, message = "OK")
//    public ResponseEntity <?> loginUser(@RequestBody Usuario userData) {
//
//        Map<String, Object> mensajeBody = new HashMap<>();
//
//        Optional <Usuario> user = servicio.loguearUsuario(userData);
//        if(user.get().getUserPassword().equals(userData.getUserPassword())) {
//            mensajeBody.put("mensaje", "El usuario pudo loguearse correctamente.");
//            return ResponseEntity.ok().body(mensajeBody);
//        } else {
//            mensajeBody.put("mensaje", "El usuario no se encuentra registrado.");
//            return ResponseEntity.badRequest().body(mensajeBody);
//        }
//    }
//
//    // método para registrar un usuario nuevo, comprobando antes si el username no existe en la base de datos
//    @RequestMapping(value = "/registros", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation("Registra un usuario nuevo en la base datos, comprobando previamente si no se encuentra el username ya registrado")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Usuario registrado exitosamente"),
//            @ApiResponse(code = 400, message = "El Usuario ya se encuentra registrado")
//    })
//    public void registrarNuevoUsuario(@RequestBody Usuario userData) throws Exception {
//        Optional <Usuario> user = servicio.loguearUsuario(userData);
//        if(user.isPresent()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ingresado ya existe!");
//        } else {
//            servicio.registrarUsuario(userData);
//        }
//    }
//
//    // método para eliminar un usuario registrado en la base de datos
//    @DeleteMapping("/personas")
//    @ApiOperation("Elimina un usuario de la base datos, comprobando previamente si se encuentra registrado")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Usuario eliminado exitosamente"),
//            @ApiResponse(code = 404, message = "El usuario que se desea eliminar no existe")
//    })
//    public void eliminarUsuario(@RequestBody Usuario userData) {
//        Optional <Usuario> user = servicio.loguearUsuario(userData);
//        if(user.isPresent()){
//            servicio.eliminarUsuario(userData);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario que se desea eliminar no existe.");
//        }
//    }
//
//    // método para actualizar un usuario registrado en la base de datos (puede cambiarle la password)
//    @PutMapping("/personas")
//    @ResponseBody
//    @ApiOperation("Actualiza la contraseña de un usuario de la base datos, comprobando previamente si se encuentra registrado")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Usuario actualizado exitosamente"),
//            @ApiResponse(code = 404, message = "El usuario que se desea actualizar no existe")
//    })
//    public void actualizarUsuario(@RequestBody Usuario userData) throws Exception {
//        Optional <Usuario> user = servicio.loguearUsuario(userData);
//        if(!user.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario ingresado para actualizar no existe!");
//        } else {
//            servicio.actualizarUsuario(userData);
//        }
//    }

}
