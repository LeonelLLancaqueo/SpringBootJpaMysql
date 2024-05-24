package com.example.empresa.service;

import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.empresa.models.Usuario;
import com.example.empresa.request.UsuarioRequest;

@Service
public interface IUsuarioService {
    
    public Optional<Usuario> saveUsuario(UsuarioRequest usuario);

    public Optional<Usuario> verificarUsuario(UsuarioRequest usuarioRequest);

    public boolean deleteById(Integer id); 

    public List<Usuario> getUsuarios();

    public Optional<Usuario> getUsuarioById(Integer id);

    public Optional<Usuario> updateUsuario(Integer id, UsuarioRequest usuarioRequest);

}
