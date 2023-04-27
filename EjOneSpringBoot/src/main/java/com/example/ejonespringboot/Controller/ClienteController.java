package com.example.ejonespringboot.Controller;

import com.example.ejonespringboot.Model.Cliente;
import com.example.ejonespringboot.Model.Medicamento;
import com.example.ejonespringboot.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getAllClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllCliente());
        model.addAttribute("cliente", new Cliente());
        return "clientes";
    }

    @GetMapping("/{id}")
    public String getClienteById(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cliente Id:" + id));
        model.addAttribute("cliente", cliente);
        return "cliente";
    }

    @PostMapping
    public String addCliente(Cliente cliente) {
        clienteService.addCliente(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable Long id, Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            cliente.setId(id);
            model.addAttribute("cliente", cliente);
            return "cliente";
        }

        clienteService.updateCliente(id, cliente);
        return "redirect:/clientes";
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}