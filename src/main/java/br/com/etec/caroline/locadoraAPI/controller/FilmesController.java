package br.com.etec.caroline.locadoraAPI.controller;

import br.com.etec.caroline.locadoraAPI.model.Filmes;
import br.com.etec.caroline.locadoraAPI.repository.FilmesRepository;
import br.com.etec.caroline.locadoraAPI.repository.filter.FilmeFilter;
import br.com.etec.caroline.locadoraAPI.repository.projections.ResumoFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmesRepository filmesRepositorio;

    @GetMapping("/todos")
    public List<Filmes> list(){
        return filmesRepositorio.findAll(Sort.by("nomeFilme").ascending());
    }

    @GetMapping()
    public Page<ResumoFilme> pesquisar(FilmeFilter filmeFilter, Pageable pageable) {
      return filmesRepositorio.filtrar(filmeFilter, pageable);
    }

}
