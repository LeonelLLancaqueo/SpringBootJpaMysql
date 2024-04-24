package com.example.empresa.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.empresa.models.Usuario;

@Service
public interface IUsuarioService {
    
    public Usuario saveUsuario(Usuario usuario);

    public Optional<Usuario> verificarUsuario(String usuario, String contraseña);

    public List<Map<String, Object>> getUsuarioMatchPersonas(); 
}
