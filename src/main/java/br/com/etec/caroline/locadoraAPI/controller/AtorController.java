package br.com.etec.caroline.locadoraAPI.controller;

import br.com.etec.caroline.locadoraAPI.model.Ator;
import br.com.etec.caroline.locadoraAPI.model.Genero;
import br.com.etec.caroline.locadoraAPI.repository.AtorRepository;
import br.com.etec.caroline.locadoraAPI.repository.filter.AtorFilter;
import br.com.etec.caroline.locadoraAPI.repository.filter.GeneroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorRepository atorRepositorio;

    @GetMapping("/todos")
    public List<Ator> listarTodosAtores(){
        return atorRepositorio.findAll(Sort.by("nomeAtor").ascending());
    }

  @GetMapping()
  public Page<Ator> pesquisar(AtorFilter atorFilter, Pageable pageable) {
    return atorRepositorio.filtrar(atorFilter, pageable);
  }
}
