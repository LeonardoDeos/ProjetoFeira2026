package com.example.demo.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Nome;
    private BigDecimal Preco;
    private String Setor;
    private Integer Quantidade;
    
    public Integer getId() {
        return ID;
    }
    public void setId(Integer ID) {
        this.ID = ID;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public BigDecimal getPreco() {
        return Preco;
    }
    public void setPreco(BigDecimal preco) {
        this.Preco = preco;
    }
    public String getSetor() {
        return Setor;
    }
    public void setSetor(String setor) {
        this.Setor = setor;
    }
    public Integer getQuantidade() {
        return Quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }
    public Produto() {
    }
    public Produto(Integer iD, String nome, BigDecimal preco, String setor, Integer quantidade) {
        ID = ID;
        nome = nome;
        Preco = preco;
        Setor = setor;
        Quantidade = quantidade;
    }
}

    
