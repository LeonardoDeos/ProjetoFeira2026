package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Produto;

 
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<List<Produto>> findByNome(String nome);
    Produto findById(Long Id);

}
