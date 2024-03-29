package br.com.etec.caroline.locadoraAPI.repository.ator;

import br.com.etec.caroline.locadoraAPI.model.Ator;
import br.com.etec.caroline.locadoraAPI.repository.filter.AtorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AtorRepositoryQuery {
  public Page<Ator> filtrar(AtorFilter atorFilter, Pageable pageable);
}
