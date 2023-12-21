package br.com.nicolasdev.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasdev.ecommerce.model.Produto;
import br.com.nicolasdev.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarProduto(Long id, Produto atualizarProduto) {
        // Verificar se o produto com o ID fornecido existe antes de tentar atualizar
        if (produtoRepository.existsById(id)) {
            atualizarProduto.setId(id);
            return produtoRepository.save(atualizarProduto);
        } else {
            // Lidar com o caso em que o produto com o ID fornecido não existe
            return null;
        }
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
