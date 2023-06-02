package br.com.etec.caroline.locadoraAPI.repository.projections;

public class ResumoFilme {

    private Long idfilme;

    private String nomefilme;

    private String descricao; // genero

    private String nomeator;

    public ResumoFilme(Long idfilme, String nomefilme, String descricao, String nomeator) {
        this.idfilme = idfilme;
        this.nomefilme = nomefilme;
        this.descricao = descricao;
        this.nomeator = nomeator;
    }
}

