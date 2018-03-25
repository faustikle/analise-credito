package br.faustikle.desafio.api.application.controller;

import br.faustikle.desafio.api.application.service.ClienteService;
import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente obter(@PathVariable Long id) {
        return clienteService.obter(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('CAPTADOR_DE_PROPOSTA')")
    public Page<Cliente> listar(@RequestParam(value = "cpf", required=false) String cpf, Pageable pageable) {
        if (cpf == null) {
            return clienteService.listar(pageable);
        }

        return clienteService.pesquisar(cpf, pageable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CAPTADOR_DE_PROPOSTA')")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.cadastrar(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CAPTADOR_DE_PROPOSTA')")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }
}
