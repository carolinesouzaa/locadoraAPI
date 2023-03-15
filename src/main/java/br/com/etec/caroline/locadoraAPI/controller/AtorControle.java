package br.com.etec.caroline.locadoraAPI.controller;

import br.com.etec.caroline.locadoraAPI.model.Ator;
import br.com.etec.caroline.locadoraAPI.repository.AtorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorControle {

    @Autowired
    private AtorRepositorio atorRepositorio;

    public List<Ator> list(){
        return atorRepositorio.findAll();
    }

}
