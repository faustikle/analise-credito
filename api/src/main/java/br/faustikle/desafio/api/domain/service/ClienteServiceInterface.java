package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.cliente.Cpf;

import java.util.List;

public interface ClienteServiceInterface {

    public Cliente cadastrar(Cliente cliente);

    public Cliente atualizar(Cliente cliente);

    public List<Cliente> pesquisar(Cpf cpf);
}
