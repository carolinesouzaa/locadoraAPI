package br.com.etec.caroline.locadoraAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "filmes")

public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomefilme;

    @ManyToOne
    @JoinColumn(name="idgenero")
    private Genero idgenero;

    @ManyToOne
    @JoinColumn(name = "idator")
    private Ator idator;

}
