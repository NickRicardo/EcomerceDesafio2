package br.com.nicolasdev.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nicolasdev.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
