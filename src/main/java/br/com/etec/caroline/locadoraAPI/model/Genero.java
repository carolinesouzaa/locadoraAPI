package br.com.etec.caroline.locadoraAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "generos")

public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgenero;

    private String generofilme;

    @JsonIgnore
    @OneToMany (mappedBy = "idgenero")
    private List<Filmes> filmesgenero = new ArrayList<>();


  public Integer getIdgenero() {
    return idgenero;
  }

  public void setIdgenero(Integer idgenero) {
    this.idgenero = idgenero;
  }

  public String getGenerofilme() {
    return generofilme;
  }

  public void setGenerofilme(String generofilme) {
    this.generofilme = generofilme;
  }

  public List<Filmes> getFilmesgenero() {
        return filmesgenero;
    }

    public void setFilmesgenero(List<Filmes> filmesgenero) {
        this.filmesgenero = filmesgenero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return idgenero.equals(genero.idgenero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgenero);
    }
}
