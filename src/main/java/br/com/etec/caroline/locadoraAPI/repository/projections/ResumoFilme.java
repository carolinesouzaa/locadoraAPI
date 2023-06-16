package br.com.etec.caroline.locadoraAPI.repository.projections;

public class ResumoFilme {

    private Long idfilme;

    private String nomefilme;

    private String generofilme; // genero

    private String nomeator;

    public ResumoFilme(Long idfilme, String nomefilme, String descricao, String nomeator) {
        this.idfilme = idfilme;
        this.nomefilme = nomefilme;
        this.generofilme = descricao;
        this.nomeator = nomeator;
    }

    public Long getIdfilme(){
        return idfilme;
    }
}

