package br.com.etec.caroline.locadoraAPI.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "filmes")

public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfilme;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Filmes filmes = (Filmes) o;
      return idfilme.equals(filmes.idfilme);
    }

    @Override
    public int hashCode() {
      return Objects.hash(idfilme);
    }

    public Long getId() {
      return idfilme;
    }

    public void setId(Long id) {
      this.idfilme = id;
    }

    private String nomefilme;

    public String getNomefilme() {
      return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
      this.nomefilme = nomefilme;
    }

    @ManyToOne
    @JoinColumn(name="idgenero")
    private Genero idgenero;

    @ManyToOne
    @JoinColumn(name = "idator")
    private Ator idator;

}
