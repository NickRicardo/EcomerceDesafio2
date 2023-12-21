package br.com.nicolasdev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.nicolasdev.ecommerce.model.Categoria;
import br.com.nicolasdev.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obterTodasCategorias() {
        List<Categoria> categorias = categoriaService.obterTodos();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obterCategoriaPorId(@PathVariable Long id) {
        return categoriaService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.adicionar(categoria);
        return ResponseEntity.ok(novaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria atualizarCategoria) {
        Categoria categoriaAtualizada = categoriaService.atualizarCategoria(id, atualizarCategoria);
        if (categoriaAtualizada != null) {
            return ResponseEntity.ok(categoriaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
