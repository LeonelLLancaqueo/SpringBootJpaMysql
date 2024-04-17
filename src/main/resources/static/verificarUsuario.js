

async function enviarCredenciales(){

    const usuario= document.getElementById("usuarioInput").value;
    const contraseña= document.getElementById("contraseñaInput").value;

    const reponse = await fetch(`/usuario/verificar?usuario=${usuario}&contraseña=${contraseña}`)
    .then( datos =>{
        return datos.json();
    }).then( data =>{
        validarCredenciales(data);    
    })
} 

function validarCredenciales(data){
    console.log(data);
}

function iniciarSesion(data){
   
}