const url = "http://localhost:8080/carros";

function salvar() {
    const carro = {
        nome: document.getElementById("nome").value,
        marca: document.getElementById("marca").value,
        modelo: document.getElementById("modelo").value,
        ano: parseInt(document.getElementById("ano").value),
        preco: parseFloat(document.getElementById("preco").value),
        disponivel: document.getElementById("disponivel").checked
    };

    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(carro)
    })
    .then(() => listar())
    .catch(err => console.error(err));
}

function listar() {
    fetch(url)
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById("lista");
            lista.innerHTML = "";

            data.forEach(carro => {
                const li = document.createElement("li");
                li.innerText = `${carro.nome} - ${carro.marca} - ${carro.preco}`;
                lista.appendChild(li);
            });
        });
}

// carrega ao abrir
listar();