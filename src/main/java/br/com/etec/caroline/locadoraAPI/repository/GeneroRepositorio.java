package br.com.etec.caroline.locadoraAPI.repository;

import br.com.etec.caroline.locadoraAPI.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer> {
}
