package com.example.empresa;






import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

        Persona personaTest= new Persona("leonel","llancaqueo", 43684498, new Date());
        List <Persona>listaPersonas= new ArrayList<Persona>();
        listaPersonas.add(personaTest);
    
        
        Mockito.when(personaService.getPersonas())
            .thenReturn(listaPersonas);
    }

    @Test
    public void requestGetpersonas() throws Exception{

    
        mvc.perform(MockMvcRequestBuilders.get("/personas"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].nombre", is("leonel")));

        
        }



}

