package br.faustikle.desafio.api.infrastructure.persistence.repository;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

    public Page<Cliente> findByDadoPessoalCpfNumero(String cpf, Pageable pageable);

    public Optional<Cliente> findOneByDadoPessoalCpfNumero(String cpf);
}
