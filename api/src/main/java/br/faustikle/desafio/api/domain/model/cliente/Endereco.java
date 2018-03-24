package br.faustikle.desafio.api.domain.model.cliente;

public class Endereco {

    private String logradouro;

    private String numero;

    private String cep;

    private String cidade;

    private String estado;

    public Endereco(String logradouro, String numero, String cep, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}
