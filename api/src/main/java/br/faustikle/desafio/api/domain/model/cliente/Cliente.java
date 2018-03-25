package br.faustikle.desafio.api.domain.model.cliente;

import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean possuiPropostasEmAnalise() {
        if (propostas.isEmpty()) {
            return false;
        }

        List<PropostaDeCredito> propostasEmAnalise = propostas.stream()
                .filter(PropostaDeCredito::estaEmAnalise)
                .collect(Collectors.toList());


        return !propostasEmAnalise.isEmpty();
    }

    public Long getId() {
        return id;
    }

    public DadoPessoal getDadoPessoal() {
        return dadoPessoal;
    }

    public void setDadoPessoal(DadoPessoal dadoPessoal) {
        this.dadoPessoal = dadoPessoal;
    }

    public void setDadoFinanceiro(DadoFinanceiro dadoFinanceiro) {
        this.dadoFinanceiro = dadoFinanceiro;
    }

    public void setPropostas(List<PropostaDeCredito> propostas) {
        this.propostas = propostas;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public DadoFinanceiro getDadoFinanceiro() {
        return dadoFinanceiro;
    }
}
