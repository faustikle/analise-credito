package br.faustikle.desafio.api.domain.model.cliente;

import java.math.BigDecimal;

public class DadoFinanceiro {

    private String profissao;

    private BigDecimal rendaMensal;

    public DadoFinanceiro(String profissao, BigDecimal rendaMensal) {
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
    }
}
