package com.example.empresa.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empresa.models.AuthResponse;
import com.example.empresa.models.Role;
import com.example.empresa.models.Usuario;
import com.example.empresa.repository.IUsuarioRepository;
import com.example.empresa.request.UsuarioRequest;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AuthService {

    private final IUsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(UsuarioRequest usuarioRequest) {
        
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioRequest.getUsuario(), usuarioRequest.getContraseña()));
            Usuario user= usuarioRepository.verificarNombreUsuario(usuarioRequest.getUsuario()).orElseThrow();
           
            String token= jwtService.getToken(user);
            
            

            return AuthResponse.builder()
            .token(token)
            .user(user)            
            .build();
    }

    public AuthResponse register(UsuarioRequest usuarioRequest) {
        Role role;
        
        role= usuarioRequest.getRole();
        if( role == null){
            role = Role.USER;
        }


        Usuario usuario= Usuario.builder()
            .usuario(usuarioRequest.getUsuario())
            .contraseña(passwordEncoder.encode(usuarioRequest.getContraseña()))
            .role(role)
            .build();

        usuarioRepository.save(usuario);

        return AuthResponse.builder()
            .token( jwtService.getToken(usuario))
            .user(usuario)
            .build();
    }


}
