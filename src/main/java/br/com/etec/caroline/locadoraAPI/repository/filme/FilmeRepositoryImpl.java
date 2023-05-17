package br.com.etec.caroline.locadoraAPI.repository.filme;

import br.com.etec.caroline.locadoraAPI.model.Filmes;
import br.com.etec.caroline.locadoraAPI.repository.filter.FilmeFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FilmeRepositoryImpl implements FilmeRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;
  @Override
  public Page<Filmes> filtrar(FilmeFilter filmeFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Filmes> criteria = builder.createQuery(Filmes.class);
    Root<Filmes> root = criteria.from(Filmes.class);

    Predicate[] predicates = criarRestricoes(filmeFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomeFilme")));

    TypedQuery<Filmes> query = manager.createQuery(criteria);

    return null;
  }

  private Predicate[] criarRestricoes(FilmeFilter filmeFilter, CriteriaBuilder builder, Root<Filmes> root) {
    List<Predicate> predicates = new ArrayList<>();

      if (!StringUtils.isEmpty(filmeFilter.getNomefilme())) {
        predicates.add(builder.like(builder.lower(root.get("generoFilme")),
                "%" + filmeFilter.getNomefilme().toLowerCase() + "%" ));

    }

      return predicates.toArray((new Predicate[predicates.size()]));
  }
}
