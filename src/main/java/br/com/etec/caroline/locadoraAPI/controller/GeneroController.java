package br.com.etec.caroline.locadoraAPI.controller;

import br.com.etec.caroline.locadoraAPI.model.Genero;
import br.com.etec.caroline.locadoraAPI.repository.GeneroRepository;
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
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepositorio;

    @GetMapping("/todos")
    public List<Genero> listarTodosGeneros() {
        return generoRepositorio.findAll(Sort.by("generoFilme").ascending());
    }

    @GetMapping()
    public Page<Genero> pesquisar(GeneroFilter generoFilter, Pageable pageable) {
      return generoRepositorio.filtrar(generoFilter, pageable);
    }
}
