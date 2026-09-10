package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProdutoController {

    // Serve para fazer a injeção da dependência
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
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
    public ResponseEntity<String> deletarProduto(@RequestParam Integer id) {
        
        Produto produtoInfo = produtoRepository.findById(id).orElse(null);
        
        if (produtoInfo == null) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.delete(produtoInfo);
        
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }

    @PostMapping("/AlterarProduto")
    public ResponseEntity<String> alterarProduto(
            @RequestParam Integer id,
            @RequestParam String nome,
            @RequestParam BigDecimal preco,
            @RequestParam Integer quantidade,
            @RequestParam String setor
    ) {

        Produto produtoInfo = produtoRepository.findById(id).orElse(null);
        
        if (produtoInfo == null) {
            return ResponseEntity.notFound().build();
        }

        produtoInfo.setNome(nome);
        produtoInfo.setPreco(preco);
        produtoInfo.setQuantidade(quantidade);
        produtoInfo.setSetor(setor);

        produtoRepository.save(produtoInfo);

        return ResponseEntity.ok("Produto alterado com sucesso!");
    }

    @GetMapping("/listar")
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }
}