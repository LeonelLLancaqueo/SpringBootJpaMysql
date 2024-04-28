package com.example.empresa.repository;

import java.util.List;
import java.util.Map;
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
    //obtenemos las personas q tengan un usuario registrado
    //realizamos un join entre las tablas persona y usuarios en la db
    @Query(value="select u.idPersona, u.usuario, u.contraseña, p.nombre, p.apellido, p.dni, p.fecha_nacimiento from usuario u, persona p where u.idPersona = p.id", nativeQuery = true)
    public List<Map<String,Object>> getUsuarioMathPerson();

    
    
}
