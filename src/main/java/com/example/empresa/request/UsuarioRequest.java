package com.example.empresa.request;

import com.example.empresa.models.Role;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    
    @NotEmpty(message = "el usuario no debe estar vacio")
    private String usuario;
    @NotEmpty(message = "la contraseña no debe estar vacio")
    private String contraseña;
    Role role;
}
