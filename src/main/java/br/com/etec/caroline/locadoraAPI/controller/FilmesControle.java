package br.com.etec.caroline.locadoraAPI.controller;

import br.com.etec.caroline.locadoraAPI.model.Ator;
import br.com.etec.caroline.locadoraAPI.model.Filmes;
import br.com.etec.caroline.locadoraAPI.repository.AtorRepositorio;
import br.com.etec.caroline.locadoraAPI.repository.FilmesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesControle {

    @Autowired
    private FilmesRepositorio filmesRepositorio;

    public List<Filmes> list(){
        return filmesRepositorio.findAll();
    }

}
