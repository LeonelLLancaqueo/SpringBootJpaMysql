package com.example.empresa.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.models.Usuario;

import com.example.empresa.request.UsuarioRequest;
import com.example.empresa.service.IPersonaService;
import com.example.empresa.service.IUsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IPersonaService personaService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping
    public ResponseEntity<Object> registrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){

        Optional<Usuario> user= usuarioService.saveUsuario(usuarioRequest);
       
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ya se encuentra registrado el nombre de usuario");
        
    }

    @PostMapping("/verificarUsuario")
    public ResponseEntity<Object> verificarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){


        Optional<Usuario> user = usuarioService.verificarUsuario(usuarioRequest); 
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
            
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra registrado el usuario, no se pudo verificar");
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        
        if(usuarioService.deleteById(id)){
            return ResponseEntity.ok("Usuario eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra registrado el usuario, no se pudo eliminar");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {
        
        Optional<Usuario> user= usuarioService.updateUsuario(id, usuarioRequest);
        if(user.isPresent()){
            return ResponseEntity.ok("Usuario modificado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra registrado el usuario, no se pudo modificar");
    }

 
    
    
    

}
