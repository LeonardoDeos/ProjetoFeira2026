package com.example.demo.dto;

import java.math.BigDecimal;

public class ProdutoRequest {

    private Long ID;
    private String nome;
    private BigDecimal Preco;
    private String Setor;
    private Integer Quantidade;
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String Nome) {
        nome = Nome;
    }
    public BigDecimal getPreco() {
        return Preco;
    }
    public void setPreco(BigDecimal preco) {
        Preco = preco;
    }
    public String getSetor() {
        return Setor;
    }
    public void setSetor(String setor) {
        Setor = setor;
    }
    public Integer getQuantidade() {
        return Quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }
    public Long getId() {
        return ID;
    }
    public void setId(Long ID) {
        this.ID = ID;
    }



    
}

    