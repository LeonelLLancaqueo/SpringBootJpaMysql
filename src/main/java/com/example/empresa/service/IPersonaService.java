package com.example.empresa.service;

import com.example.empresa.models.Persona;


import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public void savePersona(Persona persona);

    public List<Persona> getPersonas();

    public Optional<Persona> getPersonaById(Integer id);

    public void deletePersonaById(Integer id);

    public void deletePersonas();

    public List<Persona> getPersonasMayoresDeEdad();

}

