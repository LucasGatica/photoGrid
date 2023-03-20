import { conectaApi } from "./conectaApi.js";

const cards = document.querySelector("[data-cards]")
let balancox = 0;
let balancoy = 0;
let contado = 0;
let qtdPonta = 0;
let qtdPonta2 =false;
let destrava = true;

function distribuiImgs(id,nome, img,texto){
    contado++;

   
    const lembranca = document.createElement("div");
    let converteId = "i"+id;
   
    lembranca.className=`cardCorpo ${converteId}`;
    

    let x =Math.floor(Math.random() *200) +balancox;
    
    let y= Math.floor(Math.random()*300) +balancoy;
    if(qtdPonta2 ){

        x=0;
        y=Math.floor(Math.random() *30)+800;
        qtdPonta2=false;
        destrava =false
        
    }
  

   

    balancox =balancox+Math.floor(Math.random() *100);
    balancoy = balancoy+Math.floor(Math.random()*360);
   

    if(balancoy>1300){
        balancoy=1460;
        balancox=0;
        y = 1460;
        qtdPonta++;
    }

    if(qtdPonta >=2 && destrava){
        x =Math.floor(Math.random() *50)+ 400;
        y = Math.floor(Math.random() *30)+5;
        qtdPonta2 = true;
    }
   

    
    if(x>400){
        x=400;
        
    }
    if(contado==1){
        y = Math.floor(Math.random() *50)+5;
        x =  Math.floor(Math.random() *50)+5;
        
        
        

    }
    
 
    console.log(balancox+  " e " + "e" + x + "///"+ balancoy +" "+ y +" "+nome)

    

    
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



