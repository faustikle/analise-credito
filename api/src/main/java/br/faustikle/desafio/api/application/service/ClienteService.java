package br.faustikle.desafio.api.application.service;

import br.faustikle.desafio.api.domain.exception.ClienteNaoEncontradoException;
import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.service.ClienteServiceInterface;
import br.faustikle.desafio.api.infrastructure.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService implements ClienteServiceInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obter(Long clienteId) throws ClienteNaoEncontradoException {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (!cliente.isPresent()) {
            throw new ClienteNaoEncontradoException();
        }

        return cliente.get();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return null;
    }

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Page<Cliente> pesquisar(String cpf, Pageable pageable) {
        return this.clienteRepository.findByDadoPessoalCpfNumero(cpf, pageable);
    }
}
