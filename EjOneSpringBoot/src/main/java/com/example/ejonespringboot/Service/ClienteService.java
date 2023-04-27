package com.example.ejonespringboot.Service;

import com.example.ejonespringboot.Model.Cliente;
import com.example.ejonespringboot.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void updateCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
}
}