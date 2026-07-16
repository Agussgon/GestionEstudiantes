const body=document.querySelector("body")
const button= document.querySelector("#registrar")
const urlCreate="https://gestionestudiantes-vi8f.onrender.com/estudiantes" //"http://localhost:8081/estudiantes"
const nombreEstudiante= document.querySelector("#nombre") //aca no se guarda el valor
const notaEstudiante= document.getElementById("nota")
const mensajeCreado= document.getElementById("creado")

button.addEventListener('click',(e)=>{


    //detiene el evento
e.preventDefault()

//validar
let estudiantePayload={
      //  id:null,
        nombre:nombreEstudiante.value,
        nota: notaEstudiante.value
    }

if(validar(estudiantePayload)){
cargarEstudiante(estudiantePayload)

setTimeout(()=>{document.getElementById("creado").innerHTML = "" },10000)

}

})

//post
function cargarEstudiante(estudiante) {

    settings={
     method:'POST',
     headers:{"content-type":"application/json"},
     body:JSON.stringify(estudiante)
    }

    //console.log(estudiante);


    fetch(urlCreate,settings)
    .then(response =>{
        if (!response.ok) throw new Error("error")
        return response.json()
        } )
        .then(mensaje => {
            console.log(mensaje)
            
            visualizar(mensaje)})
        .catch(error =>console.log(error))

}



function visualizar(mensaje) {
    template=`<div > <h2>Estudiante ${mensaje.nombre}creado:</h2> ${mensaje.nota} </div> `
    mensajeCreado.innerHTML+= template


}

function validar(estudiante) {
   if(estudiante.nombre.trim().length < 3 || parseInt(estudiante.nombre)
   || estudiante.nota > 10 || estudiante.nota < 1){
    alert('Campos inválidos....reglas')
    return false
   }
   return true

}