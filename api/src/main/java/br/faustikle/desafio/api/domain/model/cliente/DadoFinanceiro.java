package br.faustikle.desafio.api.domain.model.cliente;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Embeddable
public class DadoFinanceiro {

    private String profissao;

    @NumberFormat(pattern = "###.###,##")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999.99")
    @Column(nullable = true)
    private BigDecimal rendaMensal;

    public DadoFinanceiro(String profissao, BigDecimal rendaMensal) {
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
    }
}
