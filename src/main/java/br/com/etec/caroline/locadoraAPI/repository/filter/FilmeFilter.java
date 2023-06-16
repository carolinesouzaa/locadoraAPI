package br.com.etec.caroline.locadoraAPI.repository.filter;

public class FilmeFilter {

  private String nomefilme;

  public String getNomefilme() {
    return nomefilme;
  }

  public void setNomefilme(String nomefilme) {
    this.nomefilme = nomefilme;
  }

  public String getGenerofilme() {
    return generofilme;
  }

  public void setGenerofilme(String generofilme) {
    this.generofilme = generofilme;
  }

  private String generofilme;

  public String getNomeator() {
    return nomeator;
  }

  public void setNomeator(String nomeator) {
    this.nomeator = nomeator;
  }

  private String nomeator;
}
