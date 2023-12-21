package br.com.nicolasdev.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nicolasdev.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
