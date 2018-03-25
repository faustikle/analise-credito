package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.cliente.Cpf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteServiceInterface {

    public Cliente cadastrar(Cliente cliente);

    public Cliente atualizar(Long id, Cliente cliente);

    public Cliente obter(Long clienteId);

    public Page<Cliente> listar(Pageable pageable);

    public Page<Cliente> pesquisar(String cpf, Pageable pageable);
}
