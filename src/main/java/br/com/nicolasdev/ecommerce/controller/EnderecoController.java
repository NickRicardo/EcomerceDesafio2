package br.com.nicolasdev.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.nicolasdev.ecommerce.model.Endereco;
import br.com.nicolasdev.ecommerce.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> obterEnderecoPorId(@PathVariable Long id) {
        return enderecoService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.adicionar(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco atualizarEndereco) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, atualizarEndereco);
        if (enderecoAtualizado != null) {
            return ResponseEntity.ok(enderecoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
