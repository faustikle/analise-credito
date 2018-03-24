package br.faustikle.desafio.api.domain.model.proposta;

import java.math.BigDecimal;

public class Credito {

    private BigDecimal valor;

    public Credito(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
