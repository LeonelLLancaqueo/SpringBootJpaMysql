
const personaTable= document.querySelector(".persona-table");

document.addEventListener("DOMContentLoaded", ()=>{
fetch('/personas').then( data=>{
    return data.json();
}).then( datos =>{
    getPersonas(datos);
})

})

function getPersonas(datos){

    datos.forEach(persona => {

        const nombre= document.createElement("td");
        nombre.textContent= persona.nombre;
        
        const apellido= document.createElement("td");
        apellido.textContent= persona.apellido;
        
        const email= document.createElement("td");
        email.textContent= persona.email;
        
        const fechaNacimiento= document.createElement("td");
        fechaNacimiento.textContent= persona.fechaNacimiento;

        const tupla = document.createElement("tr");

        tupla.appendChild(nombre);
        tupla.appendChild(apellido);
        tupla.appendChild(email);
        tupla.appendChild(fechaNacimiento);
        
        
        personaTable.appendChild(tupla);
    });


}

