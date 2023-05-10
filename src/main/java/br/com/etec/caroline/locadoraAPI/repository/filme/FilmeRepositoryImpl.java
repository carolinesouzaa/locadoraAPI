package br.com.etec.caroline.locadoraAPI.repository.filme;

import br.com.etec.caroline.locadoraAPI.model.Filmes;
import br.com.etec.caroline.locadoraAPI.repository.filter.FilmeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FilmeRepositoryImpl implements FilmeRepositoryQuery{
  @Override
  public Page<Filmes> filtrar(FilmeFilter filmeFilter, Pageable pageable) {
    return null;
  }
}
