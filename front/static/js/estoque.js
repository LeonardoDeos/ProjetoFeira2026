const listaProdutos = document.getElementById("listaProdutos");
const btnAtualizar = document.getElementById("btnAtualizar");

const modalAlterar = document.getElementById("modalAlterar");
const formAlterar = document.getElementById("formAlterar");
const btnCancelar = document.getElementById("btnCancelar");

const alterarId = document.getElementById("alterarId");
const alterarNome = document.getElementById("alterarNome");
const alterarPreco = document.getElementById("alterarPreco");
const alterarSetor = document.getElementById("alterarSetor");
const alterarQuantidade = document.getElementById("alterarQuantidade");


// LISTAR PRODUTOS
async function carregarProdutos() {
    try {
        const resposta = await fetch("http://localhost:8080/produto/listar");

        if (!resposta.ok) {
            throw new Error("Erro ao carregar produtos");
        }

        const produtos = await resposta.json();

        listaProdutos.innerHTML = "";

        if (produtos.length === 0) {
            listaProdutos.innerHTML = `
                <tr>
                    <td colspan="6">Nenhum produto cadastrado.</td>
                </tr>
            `;
            return;
        }

        produtos.forEach(produto => {
            const linha = document.createElement("tr");

            linha.innerHTML = `
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>R$ ${Number(produto.preco).toFixed(2).replace(".", ",")}</td>
                <td>${produto.setor}</td>
                <td>${produto.quantidade}</td>
                <td>
                    <button class="btn-alterar" onclick="abrirAlteracao(${produto.id}, '${produto.nome}', ${produto.preco}, '${produto.setor}', ${produto.quantidade})">
                        Alterar
                    </button>

                    <button class="btn-deletar" onclick="deletarProduto(${produto.id})">
                        Deletar
                    </button>
                </td>
            `;

            listaProdutos.appendChild(linha);
        });

    } catch (erro) {
        console.error(erro);

        listaProdutos.innerHTML = `
            <tr>
                <td colspan="6">Erro ao carregar os produtos.</td>
            </tr>
        `;
    }
}


// ABRIR MODAL DE ALTERAÇÃO
function abrirAlteracao(id, nome, preco, setor, quantidade) {

    alterarId.value = id;
    alterarNome.value = nome;
    alterarPreco.value = preco;
    alterarSetor.value = setor;
    alterarQuantidade.value = quantidade;

    modalAlterar.classList.add("ativo");
}


// CANCELAR ALTERAÇÃO
btnCancelar.addEventListener("click", () => {
    modalAlterar.classList.remove("ativo");
});


// ALTERAR PRODUTO
formAlterar.addEventListener("submit", async (evento) => {
    evento.preventDefault();

    const parametros = new URLSearchParams({
        id: alterarId.value,
        nome: alterarNome.value,
        preco: alterarPreco.value,
        setor: alterarSetor.value,
        quantidade: alterarQuantidade.value
    });

    try {
        console.log("aaaaa")
        const resposta = await fetch(
        "http://localhost:8080/produto/AlterarProduto?" + parametros,

        {
            method: "POST"
        }
    );

        if (!resposta.ok) {
            throw new Error("Erro ao alterar produto");
        }

        const mensagem = await resposta.text();

        alert(mensagem);

        modalAlterar.classList.remove("ativo");

        carregarProdutos();

    } catch (erro) {
        console.error(erro);
        alert("Erro ao alterar produto.");
    }
});


// DELETAR PRODUTO
async function deletarProduto(id) {

    const confirmar = confirm("Tem certeza que deseja deletar este produto?");

    if (!confirmar) {
        return;
    }

    const parametros = new URLSearchParams({
        id: id
    });

    try {
        const resposta = await fetch(
        "http://localhost:8080/produto/deletarProduto?" + parametros,
        {
            method: "POST"
        }
    );

        if (!resposta.ok) {
            throw new Error("Erro ao deletar produto");
        }

        const mensagem = await resposta.text();

        alert(mensagem || "Produto deletado com sucesso!");

        carregarProdutos();

    } catch (erro) {
        console.error(erro);
        alert("Erro ao deletar produto.");
    }
}


// BOTÃO ATUALIZAR
btnAtualizar.addEventListener("click", carregarProdutos);


// CARREGAR AO ABRIR A PÁGINA
carregarProdutos();