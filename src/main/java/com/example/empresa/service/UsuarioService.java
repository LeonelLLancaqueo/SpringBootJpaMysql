package com.example.empresa.service;

import java.util.List;

import java.util.Optional;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empresa.models.Role;
import com.example.empresa.models.Usuario;
import com.example.empresa.repository.IUsuarioRepository;
import com.example.empresa.request.UsuarioRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final PasswordEncoder passwordEncoder;

    
    private IUsuarioRepository usuarioRepository;

    

    @Override
    public Optional<Usuario> saveUsuario(UsuarioRequest requestUsuario) { 
        Role role;
        Optional<Usuario> userAux= usuarioRepository.verificarNombreUsuario(requestUsuario.getUsuario());
        if(userAux.isPresent()){
            return Optional.empty();
        }
        
        if(requestUsuario.getRole() != null){
            role= Role.USER;
        }else{
            role= requestUsuario.getRole();
        }

        Usuario usuario= Usuario.builder()
            .contraseña(passwordEncoder.encode(requestUsuario.getContraseña()))
            .usuario(requestUsuario.getUsuario())
            .role(role)
            .build();

        return Optional.of(usuarioRepository.save(usuario));
    }

    
    public Optional<Usuario> verificarUsuario(UsuarioRequest usuarioRequest) {
        return usuarioRepository.verificarUsuario(usuarioRequest.getUsuario(), usuarioRequest.getContraseña());
    }

    

    public Optional<Usuario> getUsuarioById(Integer id) {
        return Optional.of(usuarioRepository.getReferenceById(id));
    }


    
    public boolean deleteById(Integer id) {
        boolean eliminado= false;
        Optional<Usuario> optionalUser= Optional.of(usuarioRepository.getReferenceById(id));
        
        if(optionalUser.isPresent()){
            eliminado= true;
            usuarioRepository.deleteById(id);
        }
        return eliminado;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> updateUsuario(Integer id, UsuarioRequest usuarioRequest) {
        Optional<Usuario> optionalUser= Optional.of(usuarioRepository.getReferenceById(id));
        if(optionalUser.isPresent()){
            Usuario user= optionalUser.get();
            user.setUsuario(usuarioRequest.getUsuario());
            user.setContraseña(usuarioRequest.getContraseña());
            usuarioRepository.save(user);
            
        }
        return optionalUser;
    }





    

    




}
