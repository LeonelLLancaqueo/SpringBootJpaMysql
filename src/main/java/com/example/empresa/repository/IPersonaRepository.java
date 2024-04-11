package com.example.empresa.repository;

import com.example.empresa.models.Persona;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM persona p WHERE DATEDIFF(CURRENT_DATE(), p.fecha_nacimiento)/365 >= 18 ", nativeQuery = true)
    public List<Persona> getPersonasMayoresDeEdad();




}
