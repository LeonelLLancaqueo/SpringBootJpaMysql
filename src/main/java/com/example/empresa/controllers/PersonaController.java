package com.example.empresa.controllers;

import com.example.empresa.models.Persona;

import com.example.empresa.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }
    @GetMapping
    public List<Persona> getPersonas(){
        return  personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public Optional<Persona> getPersonaById(@PathVariable Integer id){
        return  personaService.getPersonaById(id);
    }

    @PostMapping
    public void savePerson(@RequestBody Persona persona){
        personaService.savePersona(persona);
    }

    @DeleteMapping
    public void deletePersons(){
        personaService.deletePersonas();
    }

    @DeleteMapping("/{id}")
    public void deletePersonaById(@PathVariable Integer id){
         personaService.deletePersonaById(id);
    }






}
