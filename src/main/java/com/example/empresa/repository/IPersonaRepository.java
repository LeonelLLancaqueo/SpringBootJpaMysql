package com.example.empresa.repository;

import com.example.empresa.models.Persona;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM persona p WHERE DATEDIFF(CURRENT_DATE(), p.fecha_nacimiento)/365 >= 18 ", nativeQuery = true)
    public List<Persona> getPersonasMayoresDeEdad();




}
