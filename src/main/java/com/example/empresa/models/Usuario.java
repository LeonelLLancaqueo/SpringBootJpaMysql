package com.example.empresa.models;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private int id;
    private String usuario;
    private String contraseña;

    public Usuario(){}

    

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }



    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    
}
