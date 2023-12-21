package br.com.nicolasdev.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nicolasdev.ecommerce.model.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, Long>{
    
}
