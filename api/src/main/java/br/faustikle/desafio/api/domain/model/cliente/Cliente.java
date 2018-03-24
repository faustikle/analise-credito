package br.faustikle.desafio.api.domain.model.cliente;

import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Long id;

    private DadoPessoal dadoPessoal;

    private DadoFinanceiro dadoFinanceiro;

    private List<PropostaDeCredito> propostas;

    public Cliente(DadoPessoal dadoPessoal, DadoFinanceiro dadoFinanceiro) {
        this.dadoPessoal = dadoPessoal;
        this.dadoFinanceiro = dadoFinanceiro;
        this.propostas = new ArrayList<>();
    }
}
