package br.com.eveloso.gasked.jetty.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.eveloso.gasked.jetty.domain.persistence.jpa.AlternativeDAO;
import br.com.eveloso.gasked.jetty.domain.persistence.jpa.QuestionDAO;
import br.com.eveloso.gasked.jetty.service.MatchService;

public class DatabaseInsertionTest {

	public static void main_(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MatchService bean = ctx.getBean(MatchService.class);
		System.out.println(bean != null);
		List<Question> questions = bean.getQuestions();
		System.out.println(questions.size());
	}
	
	public static void main__(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		QuestionDAO questionDAO = ctx.getBean(QuestionDAO.class);
		AlternativeDAO alternativeDAO = ctx.getBean(AlternativeDAO.class);
		Question question = new Question();
		Category category = new Category();
		category.setName("evangelho");
		question.setCategory(category);
		question.setDescription("Quantos discípulos/apóstolos teve Jesus?");
		List<Alternative> alternatives = new ArrayList<Alternative>();
		Alternative alternative;

		alternative = new Alternative();
		alternative.setQuestion(question);
		alternative.setResponse(false);
		alternative.setValue("20");
		alternatives.add(alternative);

		alternative = new Alternative();
		alternative.setQuestion(question);
		alternative.setResponse(false);
		alternative.setValue("10");
		alternatives.add(alternative);

		alternative = new Alternative();
		alternative.setQuestion(question);
		alternative.setResponse(true);
		alternative.setValue("12");
		alternatives.add(alternative);

		alternative = new Alternative();
		alternative.setQuestion(question);
		alternative.setResponse(false);
		alternative.setValue("8");
		alternatives.add(alternative);

		//
		question.setAlternatives(alternatives);
		//
		questionDAO.save(question);
		//
		for (Question q : questionDAO.getAll()) {
			System.out.print(q.getDescription());
			System.out.println(" - " + q.getCategory().getName());
			for (Alternative o : q.getAlternatives()) {
				System.out.print(o.getValue());
				System.out.println(" - " + o.getResponse());
			}
		}

	}

}
