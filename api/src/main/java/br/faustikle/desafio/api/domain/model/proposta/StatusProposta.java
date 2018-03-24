package br.faustikle.desafio.api.domain.model.proposta;

public enum StatusProposta {

    EM_ANALISE("EM_ANALISE"),
    APROVADA("APROVADA"),
    NEGADA("NEGADA");

    private String status;

    StatusProposta(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
