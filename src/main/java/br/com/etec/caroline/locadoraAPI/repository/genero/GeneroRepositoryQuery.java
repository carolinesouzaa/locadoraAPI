package br.com.etec.caroline.locadoraAPI.repository.genero;

import br.com.etec.caroline.locadoraAPI.model.Genero;
import br.com.etec.caroline.locadoraAPI.repository.filter.GeneroFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneroRepositoryQuery {
  public Page<Genero> filtrar(GeneroFilter generoFilter, Pageable pageable);
}
