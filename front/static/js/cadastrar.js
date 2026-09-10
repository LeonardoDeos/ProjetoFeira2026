const formulario = document.getElementById("formProduto");

formulario.addEventListener("submit", async (evento) => {

    evento.preventDefault();

    const parametros = new URLSearchParams({
        nome: document.getElementById("nome").value,
        preco: document.getElementById("preco").value,
        quantidade: document.getElementById("quantidade").value,
        setor: document.getElementById("setor").value
    });

    try {

        const resposta = await fetch("http://localhost:8080/produto/cadastrar?" + parametros, {
            method: "POST"
        });

        if (!resposta.ok) {
            throw new Error("Erro ao cadastrar produto");
        }

        alert("Produto cadastrado com sucesso!");

        formulario.reset();

    } catch (erro) {

        console.error(erro);
        alert("Erro ao cadastrar produto.");

    }
});