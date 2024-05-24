package com.example.empresa.service;


import com.example.empresa.models.Persona;

import com.example.empresa.repository.IPersonaRepository;
import com.example.empresa.request.PersonaRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository personaRepository;


    public Optional<Persona> savePersona(PersonaRequest requestPersona){

        Optional<Persona> personaAux= personaRepository.findByDni(requestPersona.getDni());
        if(personaAux.isPresent()){
            return Optional.empty();
        }
        

        Persona persona= Persona.builder()
            .nombre(requestPersona.getNombre())
            .apellido(requestPersona.getApellido())
            .dni(requestPersona.getDni())
            .fechaNacimiento(requestPersona.getFechaNacimiento())
            .build();

        return Optional.of(personaRepository.save(persona));


    }
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }


    public Optional<Persona> getPersonaById(Integer id) {
        return personaRepository.findById(id);
    }



    public boolean deletePersonaById(Integer id) {
        boolean eliminado= false;
        if(personaRepository.existsById(id)){
            eliminado= true;
            personaRepository.deleteById(id);    
        }
        
        return eliminado;
    }


    public void deletePersonas() {
        personaRepository.deleteAll();
    }

    @Override
    public List<Persona> getPersonasMayoresDeEdad() {
        return personaRepository.getPersonasMayoresDeEdad();
    }
    @Override
    public Boolean updatePersona(Integer id, PersonaRequest personaRequest) {
        Boolean update= false;
        Persona persona= personaRepository.getReferenceById(id);
        if(persona != null){
            persona.setNombre(personaRequest.getNombre());
            persona.setApellido(personaRequest.getApellido());
            persona.setDni(personaRequest.getDni());
            persona.setFechaNacimiento(personaRequest.getFechaNacimiento());
            update= true;
            personaRepository.save(persona);
        }
        return update;    
        
    }


}