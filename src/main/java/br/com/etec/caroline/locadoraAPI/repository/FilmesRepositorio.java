package br.com.etec.caroline.locadoraAPI.repository;

import br.com.etec.caroline.locadoraAPI.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepositorio extends JpaRepository<Filmes, Long> {
}
