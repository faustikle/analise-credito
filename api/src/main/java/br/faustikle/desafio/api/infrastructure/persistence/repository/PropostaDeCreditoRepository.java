package br.faustikle.desafio.api.infrastructure.persistence.repository;

import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.proposta.StatusProposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PropostaDeCreditoRepository extends PagingAndSortingRepository<PropostaDeCredito, Long> {

    public Page<PropostaDeCredito> findByClienteDadoPessoalCpfNumero(String cpf, Pageable pageable);

    public Page<PropostaDeCredito> findByStatus(StatusProposta statusProposta, Pageable pageable);

    public Page<PropostaDeCredito> findByStatusAndClienteDadoPessoalCpfNumero(StatusProposta statusProposta,
                                                                              String cpf, Pageable pageable);
}
