package br.faustikle.desafio.api.domain.model.proposta;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Embeddable
public class Credito {

    @NumberFormat(pattern = "###.###,##")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "999999.99")
    @Column(nullable = true)
    private BigDecimal valor;

    public Credito(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
