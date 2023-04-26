package br.com.etec.caroline.locadoraAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "atores")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idator;

    private String nomeator;

    @JsonIgnore
    @OneToMany(mappedBy = "idator")
    private List<Filmes> filmesator = new ArrayList<>();


    public Integer getId() {
        return idator;
    }

    public void setId(Integer id) {
        this.idator = id;
    }

    public String getNomeator() {
        return nomeator;
    }

    public void setNomeator(String nomeator) {
        this.nomeator = nomeator;
    }

    public List<Filmes> getFilmesator() {
        return filmesator;
    }

    public void setFilmesator(List<Filmes> filmesator) {
        this.filmesator = filmesator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ator ator = (Ator) o;
        return idator.equals(ator.idator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idator);
    }

}
