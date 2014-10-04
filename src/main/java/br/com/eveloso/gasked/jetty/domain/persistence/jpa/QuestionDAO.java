package br.com.eveloso.gasked.jetty.domain.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import br.com.eveloso.gasked.jetty.domain.Question;


@Component("questionDAO")
@Transactional
public class QuestionDAO  {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see br.com.eveloso.gasked.domain.persistence.IDAO#save(br.com.eveloso.gasked.domain.Question)
	 */
	public Integer save(Question question){
		em.persist(question);
		return question.getId();
	}
	
	/* (non-Javadoc)
	 * @see br.com.eveloso.gasked.domain.persistence.IDAO#getAll()
	 */
	public List<Question> getAll(int offset, int end){
		TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);
		query.setMaxResults(end);
		query.setFirstResult(offset);
		return query.getResultList();
	}

	public void deleteAll() {
		em.createQuery("delete from Question"); 
	}

	public Question get(Integer id) {
		return em.find(Question.class, id); 
	}
	
}
