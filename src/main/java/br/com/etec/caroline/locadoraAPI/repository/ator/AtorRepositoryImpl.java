package br.com.etec.caroline.locadoraAPI.repository.ator;

import br.com.etec.caroline.locadoraAPI.model.Ator;
import br.com.etec.caroline.locadoraAPI.repository.filter.AtorFilter;
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

public class AtorRepositoryImpl implements AtorRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;
  @Override
  public Page<Ator> filtrar(AtorFilter atorFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Ator> criteria = builder.createQuery(Ator.class);
    Root<Ator> root = criteria.from(Ator.class);

    Predicate[] predicates = criarRestricoes(atorFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomeAtor")));

    TypedQuery<Ator> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return null;
  }

  private Long total(AtorFilter atorFilter){
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Ator> root = criteria.from(Ator.class);

    Predicate[] predicates = criarRestricoes(atorFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomeAtor")));

    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Ator> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegristrosPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaAtual * totalRegristrosPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegristrosPorPagina);
  }

  private Predicate[] criarRestricoes(AtorFilter atorFilter, CriteriaBuilder builder, Root<Ator> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(atorFilter.getNomeator())) {
      predicates.add(builder.like(builder.lower(root.get("nomeAtor")), "%" + atorFilter.getNomeator().toLowerCase() + "%" ));
    }

    return predicates.toArray((new Predicate[predicates.size()]));
  }
}
