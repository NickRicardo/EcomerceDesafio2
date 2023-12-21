package br.com.nicolasdev.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasdev.ecommerce.model.Endereco;
import br.com.nicolasdev.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionar(Endereco endereco) {
        endereco.setId(null);
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> obterPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco atualizarEndereco(Long id, Endereco atualizarEndereco) {
        if (enderecoRepository.existsById(id)) {
            atualizarEndereco.setId(id);
            return enderecoRepository.save(atualizarEndereco);
        } else {
            return null;
        }
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
