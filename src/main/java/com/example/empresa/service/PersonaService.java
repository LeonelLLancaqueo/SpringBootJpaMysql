package com.example.empresa.service;


import com.example.empresa.models.Persona;
import com.example.empresa.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public void savePersona(Persona persona){

        personaRepository.save(persona);
    }
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }


    public Optional<Persona> getPersonaById(Integer id) {
        return personaRepository.findById(id);
    }



    public void deletePersonaById(Integer id) {
        personaRepository.deleteById(id);
    }


    public void deletePersonas() {
        personaRepository.deleteAll();
    }


}