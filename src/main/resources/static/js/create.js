const body=document.querySelector("body")
const button= document.querySelector("#registrar")
const urlCreate= "https://estudiantes2026.onrender.com/estudiantes"  //"http://localhost:8080/estudiantes"
const nombreEstudiante= document.querySelector("#nombre") //aca no se guarda el valor
const notaEstudiante= document.getElementById("nota")

button.addEventListener('click',(e)=>{


    //detiene el evento
e.preventDefault()

//validar
let estudiantePayload={
       // id:null,
        nombre:nombreEstudiante.value,
        nota: notaEstudiante.value
    }

if(validar(estudiantePayload)){
cargarEstudiante(estudiantePayload)
setTimeout(()=>{document.getElementById("creado").innerHTML = "" },4000)

}

})

//post
function cargarEstudiante(estudiante) {

    settings={
     method:'POST',
     headers:{"content-type":"application/json"},
     body:JSON.stringify(estudiante)
    }

    console.log(estudiante);


    fetch(urlCreate,settings)
    .then(response =>{
        if (!response.ok) throw new Error("error")
        return response.json()
        } )
        .then(mensaje => visualizar(mensaje))
        .catch(error =>console.log(error))

}



function visualizar(mensaje) {
    template=`<h2>${mensaje.nombre}</h2>`
    body.innerHTML+= `<div id="creado"> Estudiante creado:${mensaje.nota} </div> `


}

function validar(estudiante) {
   if(estudiante.nombre.trim().length < 3 || parseInt(estudiante.nombre)
   || estudiante.nota > 10 || estudiante.nota < 1){
    alert('Campos inválidos....reglas')
    return false
   }
   return true

}