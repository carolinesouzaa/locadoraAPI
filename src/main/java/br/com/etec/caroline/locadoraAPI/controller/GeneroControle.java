package br.com.etec.caroline.locadoraAPI.controller;

import br.com.etec.caroline.locadoraAPI.model.Genero;
import br.com.etec.caroline.locadoraAPI.repository.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroControle {

    @Autowired
    private GeneroRepositorio generoRepositorio;

    public List<Genero> list() {
        return generoRepositorio.findAll();
    }
}
