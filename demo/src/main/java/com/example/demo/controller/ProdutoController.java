package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Produto;
import com.example.demo.dto.ProdutoRequest;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

        //Serve para fazer a injeção da dependência
    private final ProdutoRepository produtoRepository;
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ProdutoRequest produtoRequest){
        Produto produtoInfo = new Produto();

        ProdutoInfo.setNome(produtoRequest.getNome());
        ProdutoInfo.setPreco(produtoRequest.getPreco());
        ProdutoInfo.setQuantidade(produtoRequest.getQuantidade());
        ProdutoInfo.setSetor(produtoRequest.getSetor());

        produtoRepository.save(ProdutoInfo);
        System.out.println("Produto Cadastrado com Sucesso!");
        
    }

    @PostMapping("/deletarProduto")
    public void deletarProduto(@RequestParam Long ID){
        
        Produto ProdutoInfo = produtoRepository.findById(ID);

        produtoRepository.delete(ProdutoInfo);
        System.out.println("Produto deletado com sucesso");
    
    }

    @PostMapping("/AlterarProduto")
    public void alterarProduto(@RequestBody ProdutoRequest produtoRequest){
        Produto ProdutoInfo = produtoRepository.findById(produtoRequest.getId());
        
        System.out.println(produtoRequest.getNome());
        System.out.println(produtoRequest.getPreco());
        System.out.println(produtoRequest.getQuantidade());
        System.out.println(produtoRequest.getSetor());
        ProdutoInfo.setNome(produtoRequest.getNome());
        ProdutoInfo.setPreco(produtoRequest.getPreco());
        ProdutoInfo.setQuantidade(produtoRequest.getQuantidade());
        ProdutoInfo.setSetor(produtoRequest.getSetor());
        produtoRepository.save(ProdutoInfo);
    }
}
