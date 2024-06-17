package com.example.empresa.models;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario", uniqueConstraints =  {@UniqueConstraint(columnNames = {"username"})})
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    @JsonIgnore
    private String contraseña;
    @Enumerated(EnumType.STRING)
    Role role;

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @JsonIgnore
    public String getPassword() {
        return this.contraseña;   
    }
    @Override @JsonIgnore
    public String getUsername() {
        return this.usuario;
    }
    @Override @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override @JsonIgnore
    public boolean isEnabled() {
        return true;
    }






    
}
