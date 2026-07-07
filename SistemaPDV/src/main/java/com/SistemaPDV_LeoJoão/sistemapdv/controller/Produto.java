/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SistemaPDV_LeoJoão.sistemapdv.controller;

import java.math.BigDecimal;

/**
 *
 * @author Administrador
 */
public class Produto{
    private Integer id;
    private String Nome;
    private BigDecimal Preco;
    private String Setor;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
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
    public Produto(Integer id, String nome, BigDecimal preco, String setor) {
        this.id = id;
        Nome = nome;
        Preco = preco;
        Setor = setor;
    }
    public Produto() {
    }

    
    
}
