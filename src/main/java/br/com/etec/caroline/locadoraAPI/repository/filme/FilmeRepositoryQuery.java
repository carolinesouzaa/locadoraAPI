package br.com.etec.caroline.locadoraAPI.repository.filme;

import br.com.etec.caroline.locadoraAPI.model.Filmes;
import br.com.etec.caroline.locadoraAPI.repository.filter.FilmeFilter;
import br.com.etec.caroline.locadoraAPI.repository.projections.ResumoFilme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmeRepositoryQuery {
  public Page<ResumoFilme> filtrar(FilmeFilter filmeFilter, Pageable pageable);
}
