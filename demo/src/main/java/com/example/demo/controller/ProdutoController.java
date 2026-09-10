package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProdutoController {

        //Serve para fazer a injeção da dependência
    private final ProdutoRepository produtoRepository;
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    
@PostMapping("/cadastrar")
public ResponseEntity<String> cadastrar(
        @RequestParam String nome,
        @RequestParam BigDecimal preco,
        @RequestParam Integer quantidade,
        @RequestParam String setor
) {

    Produto produtoInfo = new Produto();

    produtoInfo.setNome(nome);
    produtoInfo.setPreco(preco);
    produtoInfo.setQuantidade(quantidade);
    produtoInfo.setSetor(setor);

    produtoRepository.save(produtoInfo);

    return ResponseEntity.ok("Produto cadastrado com sucesso!");
}

    @PostMapping("/deletarProduto")
    public void deletarProduto(@RequestParam Long id){
        
        Produto ProdutoInfo = produtoRepository.findById(id);

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
