package br.com.nicolasdev.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nicolasdev.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{
    
}
