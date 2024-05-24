package com.example.empresa.controllers;

import com.example.empresa.models.Persona;
import com.example.empresa.models.Usuario;
import com.example.empresa.request.PersonaRequest;
import com.example.empresa.service.PersonaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Optional;

import org.springframework.web.server.ResponseStatusException;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }


    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas(){
        return  ResponseEntity.ok(personaService.getPersonas()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") int id){

        Optional<Persona> persona= personaService.getPersonaById(id);
        if(!persona.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found person");
        }

        return  ResponseEntity.ok(persona.get());
    }

    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonaRequest personaRequest){


        Optional<Persona> persona= personaService.savePersona(personaRequest);
       
        if(persona.isPresent()){
            return ResponseEntity.ok(persona.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ya se encuentra registrado una persona con el dni ingresado");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePersona(@PathVariable Integer id, @RequestBody @Valid PersonaRequest updatePersona) {
        
        if(personaService.updatePersona(id, updatePersona)){
            return ResponseEntity.ok("Persona modificada con exito");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("persona no encontrada");
        
    }

    @DeleteMapping
    public ResponseEntity<String> deletePersons(){
        
        personaService.deletePersonas();
        return ResponseEntity.ok("Operacion exitosa");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable Integer id){

        if(personaService.deletePersonaById(id)){
            return ResponseEntity.ok("Entidad encontrada y eliminada");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro a la persona a eliminar");
         
    }


    //querys personalizadas
    @GetMapping("/mayores-de-edad")
    public ResponseEntity<List<Persona>> getPersonasMayoresDeEdad(){
        return  ResponseEntity.ok(personaService.getPersonasMayoresDeEdad());
    }


}
