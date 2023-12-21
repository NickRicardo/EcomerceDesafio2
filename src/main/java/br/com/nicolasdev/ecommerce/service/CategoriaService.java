package br.com.nicolasdev.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasdev.ecommerce.model.Categoria;
import br.com.nicolasdev.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria atualizarCategoria) {
        if (categoriaRepository.existsById(id)) {
            atualizarCategoria.setId(id);
            return categoriaRepository.save(atualizarCategoria);
        } else {
            return null;
        }
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
