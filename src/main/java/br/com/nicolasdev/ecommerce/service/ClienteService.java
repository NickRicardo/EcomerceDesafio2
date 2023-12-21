package br.com.nicolasdev.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nicolasdev.ecommerce.model.Cliente;
import br.com.nicolasdev.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente atualizarCliente) {
        if (clienteRepository.existsById(id)) {
            atualizarCliente.setId(id);
            return clienteRepository.save(atualizarCliente);
        } else {
            return null;
        }
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
