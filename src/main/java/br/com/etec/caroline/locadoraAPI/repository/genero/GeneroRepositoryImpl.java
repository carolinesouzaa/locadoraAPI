package br.com.etec.caroline.locadoraAPI.repository.genero;

import br.com.etec.caroline.locadoraAPI.model.Genero;
import br.com.etec.caroline.locadoraAPI.repository.filter.GeneroFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

public class GeneroRepositoryImpl implements GeneroRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;
  @Override
  public Page<Genero> filtrar(GeneroFilter generoFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Genero> criteria = builder.createQuery(Genero.class);
    Root<Genero> root = criteria.from(Genero.class);

    Predicate[] predicates = criarRestricoes(generoFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("generoFilme")));

    TypedQuery<Genero> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(generoFilter));
  }

  private Long total(GeneroFilter generoFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Genero> root = criteria.from(Genero.class);

    Predicate[] predicates = criarRestricoes(generoFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("generoFilme")));

    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Genero> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegristrosPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaAtual * totalRegristrosPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegristrosPorPagina);
  }

  private Predicate[] criarRestricoes(GeneroFilter generoFilter, CriteriaBuilder builder, Root<Genero> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(generoFilter.getGenerofilme())) {
      predicates.add(builder.like(builder.lower(root.get("generoFilme")), "%" + generoFilter.getGenerofilme().toLowerCase() + "%" ));
    }

    return predicates.toArray((new Predicate[predicates.size()]));

  }
}
