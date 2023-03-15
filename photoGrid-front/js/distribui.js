import { conectaApi } from "./conectaApi.js";

const cards = document.querySelector("[data-cards]")
let balancox = 0;
let balancoy = 0;


function distribuiImgs(id,nome, img,texto){
    const lembranca = document.createElement("div");
    let converteId = "i"+id;
   
    lembranca.className=`cardCorpo ${converteId}`;
    

    let x =Math.floor(Math.random() *450) +balancox;
    let y= Math.floor(Math.random()*1500) +balancoy;

    balancox =balancox+10;
    balancoy = balancoy+10;

    
    lembranca.innerHTML=`
    

    <div class="cardImg">
                <img class="imgMemoria" src="${img}" alt="">
            </div>
            <div class="cardBaixo">
                <h1 class="cardTitulo">
                    ${nome}
                </h1>
                
                <p class="cardTexto">
                    ${texto}
                </p>

            </div>
            <style>
                .${converteId}{
                    position: fixed;
                    margin-top: ${x}px;
                    margin-left:  ${y}px;
                    margin-right: ${y}px;
                }
            </style>
    
    
    
    
    `

    return lembranca;

}

async function puxaPolaroids(){
    const listaPolaroids = await conectaApi.listaPolaroids();
    listaPolaroids.forEach(elemento => cards.appendChild(
        distribuiImgs(elemento.id, elemento.titulo, elemento.img,elemento.texto  )

    ))

}

puxaPolaroids();



