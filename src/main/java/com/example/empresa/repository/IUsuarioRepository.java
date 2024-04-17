package com.example.empresa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.empresa.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    
    @Query(value = "select * from usuario u where u.usuario= :usuario AND u.contraseña= :contraseña ", nativeQuery = true)
    public Optional<Usuario> verificarUsuario(
        @Param("usuario") String usuario,
        @Param("contraseña") String contraseña
    );
    
}
