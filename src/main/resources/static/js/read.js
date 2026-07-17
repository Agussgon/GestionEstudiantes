const container=document.querySelector("#container")
const url= "https://gestionestudiantes-02jr.onrender.com/estudiantes/lista" //http://localhost:8080/estudiantes"


window.addEventListener('load',()=>{

    renderizarEstudiantes()

})


function renderizarEstudiantes() {
    settings={
        method:"GET",
        headers:{"content-type":"application/json"}
    }

    fetch(url,settings)
    .then(response=>{
        if(!response.ok){ throw new Error("error al enviar request")}

       return response.json()}
    ) // transforma el json a un objeto de js
        .then(estudiantes=> { console.log(estudiantes)
        render(estudiantes) })
        .catch(e => {
            return console.error(e)
        })
}

function render(lista){
    estudiantesCartas=[]
     lista.forEach( estudiante => {
        template=`<div class=card> <h3>${estudiante.nombre} </h3>
        <p>Id: ${estudiante.id}<p/>
        <p>Nota: ${estudiante.nota}</p>
        </div> `
        estudiantesCartas.push(template)
     });
        container.innerHTML = estudiantesCartas

    }