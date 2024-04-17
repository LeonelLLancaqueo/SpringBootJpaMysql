package com.example.empresa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa.models.Usuario;
import com.example.empresa.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository){
        this.usuarioRepository= usuarioRepository;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) { 
        return usuarioRepository.save(usuario);
    }

    
    public Optional<Usuario> verificarUsuario(String usuario, String contraseña) {
        return usuarioRepository.verificarUsuario(usuario, contraseña);
    }

    




}
