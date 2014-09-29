package br.com.eveloso.gasked.jetty.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eveloso.gasked.jetty.domain.Alternative;
import br.com.eveloso.gasked.jetty.domain.Category;
import br.com.eveloso.gasked.jetty.domain.Question;
import br.com.eveloso.gasked.jetty.service.MatchService;


@Controller
public class LoadDataBase {

	@Autowired
	private MatchService matchService;
	
	@RequestMapping("/")
	public String helloWorld() {
		matchService.clearDataBase();
		Question question;
		Category category;
		
		category = new Category("evangelho");
		question = new Question("Quantos discípulos/apóstolos teve Jesus?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("20", false, question));
		question.getAlternatives().add(new Alternative("10", false, question));
		question.getAlternatives().add(new Alternative("12", true, question));
		question.getAlternatives().add(new Alternative("8", false, question));
		matchService.save(question);

		category = new Category("Gênesis");
		question = new Question("Qual o tipo de meio de transporte usou Noé?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Arca", true, question));
		question.getAlternatives().add(new Alternative("Trem", false, question));
		question.getAlternatives().add(new Alternative("Camelo", false, question));
		question.getAlternatives().add(new Alternative("Cavalo", false, question));
		matchService.save(question);

		category = new Category("velho testamento");
		question = new Question("Que animal engoliu Jonas?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Jibóia", false, question));
		question.getAlternatives().add(new Alternative("Elefante", false, question));
		question.getAlternatives().add(new Alternative("Baleia", true, question));
		question.getAlternatives().add(new Alternative("Dinosauro", false, question));
		matchService.save(question);

		
		category = new Category("Gênesis");
		question = new Question("Como chamava o jardim onde morou o primeiro casal da terra?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Jardim Botânico", false, question));
		question.getAlternatives().add(new Alternative("Jardim do Éden", true, question));
		question.getAlternatives().add(new Alternative("Jardim das Oliveiras", false, question));
		question.getAlternatives().add(new Alternative("Jardim das Flores", false, question));
		matchService.save(question);

		
		category = new Category("evangelho");
		question = new Question("Quantos capítulos tem o livro de Salmos?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("150", true, question));
		question.getAlternatives().add(new Alternative("500", false, question));
		question.getAlternatives().add(new Alternative("66", false, question));
		question.getAlternatives().add(new Alternative("15", false, question));
		matchService.save(question);

		
		category = new Category("evangelho");
		question = new Question("Diga o nome de dois dos quatro Evangelhos?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Mateus, Gênesis", false, question));
		question.getAlternatives().add(new Alternative("Paulo, Lucas", false, question));
		question.getAlternatives().add(new Alternative("Romanos, Beltranos", false, question));
		question.getAlternatives().add(new Alternative("Mateus, Marcos", true, question));
		matchService.save(question);

		
		category = new Category("velho testamento");
		question = new Question("Como era o nome do pai do Rei Salomão?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Saul", false, question));
		question.getAlternatives().add(new Alternative("Davi", true, question));
		question.getAlternatives().add(new Alternative("Salomão", false, question));
		question.getAlternatives().add(new Alternative("Jesus", false, question));
		matchService.save(question);

		
		category = new Category("velho testamento");
		question = new Question("Como é o nome do primeiro casal da terra?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("José e Maria", false, question));
		question.getAlternatives().add(new Alternative("Jacó e Raquel", false, question));
		question.getAlternatives().add(new Alternative("Adão e Eva", true, question));
		question.getAlternatives().add(new Alternative("Salomão e Salomé", false, question));
		matchService.save(question);

		
		category = new Category("evangelho");
		question = new Question("Quais destes não é um livro da Bíblia?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Neemias", false, question));
		question.getAlternatives().add(new Alternative("Isaías", false, question));
		question.getAlternatives().add(new Alternative("Timóteo", false, question));
		question.getAlternatives().add(new Alternative("Paulo", true, question));
		matchService.save(question);

		
		category = new Category("evangelho");
		question = new Question("O que fez Zaqueu para ver Jesus?", category, new ArrayList<Alternative>());
		question.getAlternatives().add(new Alternative("Fugiu para o deserto", false, question));
		question.getAlternatives().add(new Alternative("Foi pescar", false, question));
		question.getAlternatives().add(new Alternative("Subiu em uma árvore", true, question));
		question.getAlternatives().add(new Alternative("Gritou o nome de Jesus", false, question));
		matchService.save(question);
		
		return "index";
	}
	
	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}
	
}
