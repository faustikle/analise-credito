package br.faustikle.desafio.api.domain.model.cliente;

import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Embedded
    @Enumerated(EnumType.STRING)
    private DadoPessoal dadoPessoal;

    @Embedded
    private DadoFinanceiro dadoFinanceiro;

    @OneToMany(mappedBy = "cliente", targetEntity = PropostaDeCredito.class,
            fetch = FetchType.LAZY)
    private List<PropostaDeCredito> propostas;

    private LocalDateTime data;

    private Cliente() {
        this.data = LocalDateTime.now();
    }

    public Cliente(DadoPessoal dadoPessoal, DadoFinanceiro dadoFinanceiro) {
        this.dadoPessoal = dadoPessoal;
        this.dadoFinanceiro = dadoFinanceiro;
        this.propostas = new ArrayList<>();
        this.data = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public DadoPessoal getDadoPessoal() {
        return dadoPessoal;
    }

    public DadoFinanceiro getDadoFinanceiro() {
        return dadoFinanceiro;
    }
}
