package br.com.eveloso.gasked.jetty.domain.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import br.com.eveloso.gasked.jetty.domain.Alternative;
import br.com.eveloso.gasked.jetty.domain.persistence.IDAO;


@Component("alternativeDAO")
@Transactional
public class AlternativeDAO implements IDAO<Alternative>{

	@PersistenceContext
	private EntityManager em;
	
	public Integer save(Alternative option){
		em.persist(option);
		return option.getId();
	}
	
	public List<Alternative> getAll(){
		return em.createQuery("select q from Alternative q", Alternative.class).getResultList();
	}
	
}
