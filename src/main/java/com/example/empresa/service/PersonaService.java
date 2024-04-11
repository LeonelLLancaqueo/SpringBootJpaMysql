package com.example.empresa.service;


import com.example.empresa.models.Persona;
import com.example.empresa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository personaRepository;


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

    @Override
    public List<Persona> getPersonasMayoresDeEdad() {
        return personaRepository.getPersonasMayoresDeEdad();
    }


}