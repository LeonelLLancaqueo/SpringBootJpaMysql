package com.example.empresa.service;

import com.example.empresa.models.Persona;
import com.example.empresa.request.PersonaRequest;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public Optional<Persona> savePersona(PersonaRequest personaRequest);

    public List<Persona> getPersonas();

    public Optional<Persona> getPersonaById(Integer id);

    public boolean deletePersonaById(Integer id);

    public void deletePersonas();

    public List<Persona> getPersonasMayoresDeEdad();

    public Boolean updatePersona(Integer id, PersonaRequest personaRequest);
    

}

