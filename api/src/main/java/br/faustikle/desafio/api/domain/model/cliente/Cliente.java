package br.faustikle.desafio.api.domain.model.cliente;

import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DadoPessoal dadoPessoal;

    @Embedded
    private DadoFinanceiro dadoFinanceiro;

    @OneToMany(mappedBy = "cliente", targetEntity = PropostaDeCredito.class,
            fetch = FetchType.LAZY)
    private List<PropostaDeCredito> propostas;

    public Cliente(DadoPessoal dadoPessoal, DadoFinanceiro dadoFinanceiro) {
        this.dadoPessoal = dadoPessoal;
        this.dadoFinanceiro = dadoFinanceiro;
        this.propostas = new ArrayList<>();
    }
}
