async function listaPolaroids(){
 
    const conexao = await fetch("http://localhost:5003/polaroids");
    const conexaoConvertida = await conexao.json();

    return conexaoConvertida;
}


export const conectaApi ={
    listaPolaroids
}
