package br.com.etec.caroline.locadoraAPI.repository;

import br.com.etec.caroline.locadoraAPI.model.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepositorio extends JpaRepository<Ator, Integer> {
}
