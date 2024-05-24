package com.example.empresa.request;

import java.time.LocalDate;



import jakarta.persistence.Column;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PersonaRequest {


    @NotEmpty(message = "EL campo nombre no  puede estar vacio")
    @Size(min=3, max=60, message = "El nombre es requerido")
    private String nombre;

    @NotEmpty(message = "EL campo apellido no  puede estar vacio")
    @Size(min=3, max=60, message = "El nombre es requerido")
    private String apellido;

    @NotNull(message = "EL campo dni no  puede estar vacio")
    private int dni;

    @Column(name="fecha_nacimiento")
    @NotNull(message = "EL campo fecha no  puede estar vacio")
    @Temporal(TemporalType.DATE)
    
    private LocalDate fechaNacimiento;

    
    
}
