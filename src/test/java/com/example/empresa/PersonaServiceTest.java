package com.example.empresa;






import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import com.example.empresa.models.Persona;

import com.example.empresa.service.PersonaService;



import static org.hamcrest.Matchers.*;





@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class PersonaServiceTest {


    
    @MockBean
    private PersonaService personaService;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setup(){
        personaService.deletePersonas();   
    }

    private List<Persona> preloadPerson(){
        //cargamos personas el repositorio
        Persona personaTest= Persona.builder()
                .nombre("leonel")
                .apellido("43684498")
                .dni(43684498)
                .fechaNacimiento(LocalDate.now())
                .build(); 
        
        
        Persona personaTest2= new Persona("juan","llancaqueo", 52417896, LocalDate.now());
        
        List <Persona>listaPersonas= new ArrayList<Persona>();
        listaPersonas.add(personaTest);
        listaPersonas.add(personaTest2);

        return listaPersonas;
    }

    @Test
    public void requestGetPersonas_WhenNotEmpty() throws Exception{
        
        //test del servicio getPersonas() cuando existen personas cargadas en la db
        
        Mockito.when(personaService.getPersonas())
            .thenReturn(preloadPerson());

        

        mvc.perform(get("/personas"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].nombre", is("leonel")))
        .andExpect(jsonPath("$[0].id", is(0)))
        .andExpect(jsonPath("$[1].nombre", is("juan")));
    }

    @Test
    public void requestGetPersonas_WhenEmpty() throws Exception{

        //test del servicio getPersonas() cuando no existen personas cargadas en la db
        
        mvc.perform(get("/personas"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(0)));
    }
    
    @Test    
    public void requestGetPersonasById_WhenNotEmpty() throws Exception{
        
        //test del servicio getPersonasById() cuando existen personas cargadas en la db

        Integer id=0;

        Mockito.when(personaService.getPersonaById(id))
        .thenReturn(Optional.of(preloadPerson().get(0)));


        mvc.perform(get("/personas/0"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.nombre", is("leonel")))
        .andExpect(jsonPath("$.id", is(0)));


    }
    




}

