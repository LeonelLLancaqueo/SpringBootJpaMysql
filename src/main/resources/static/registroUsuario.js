

async function registrarUsuario(){

    const usuario= document.getElementById("usuarioInput").value;
    const contraseña= document.getElementById("contraseñaInput").value;

    const persona= {
        "usuario": usuario, 
        "contraseña": contraseña, 
    };

    
    const response= await fetch("/usuario",{
        method: 'POST',
        cache: 'no-cache',  
        headers:{
            'content-Type': 'application/json'
        },
        body: JSON.stringify(persona),
    }); 

    
       

}