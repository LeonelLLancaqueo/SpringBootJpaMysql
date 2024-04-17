package com.example.empresa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.models.Usuario;
import com.example.empresa.service.IUsuarioService;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    IUsuarioService usuarioService;

    

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



    @PostMapping
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
             
    }

    @GetMapping("/verificar")
    public Optional<Usuario> registrarUsuario(@RequestParam(name = "usuario") String usuario, @RequestParam(name = "contraseña") String contraseña){
        return usuarioService.verificarUsuario(usuario, contraseña);
             
    }


}
