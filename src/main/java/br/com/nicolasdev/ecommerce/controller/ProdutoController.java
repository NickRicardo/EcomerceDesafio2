package br.com.nicolasdev.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.nicolasdev.ecommerce.model.Produto;
import br.com.nicolasdev.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable long id ){
        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable long id, @RequestBody Produto produto){
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        produtoService.deletarProduto(id);
    }
}
