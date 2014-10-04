package br.com.eveloso.gasked.jetty.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eveloso.gasked.jetty.domain.Alternative;
import br.com.eveloso.gasked.jetty.domain.Category;
import br.com.eveloso.gasked.jetty.domain.Question;
import br.com.eveloso.gasked.jetty.service.MatchService;
import br.com.eveloso.gasked.jetty.web.util.ConstantsUtil;
import static br.com.eveloso.gasked.jetty.web.util.ConstantsUtil.*;


@Controller
public class LoadDataBase {
	
	@Autowired
	private MatchService matchService;
	
	@RequestMapping("/")
	public String helloWorld() {
		
		matchService.clearDataBase();
		Question question;
		Category category;
		
		int i= 1;
		String questionValue, optionValue;
		
		while(  (questionValue = ConstantsUtil.getValue(PERGUNTA+i)) != null){
			int j = 1;
			category = new Category(EVANGELHO);
			question = new Question(questionValue, category, new ArrayList<Alternative>());
			while(  (optionValue = ConstantsUtil.getValue(OPCAO+i+"-"+j)) != null){
				Boolean answer =  Integer.parseInt(ConstantsUtil.getValue(RESPOSTA+i)) == j;
				question.getAlternatives().add(new Alternative(optionValue, answer, question));
				j++;
			}
			i++;
			matchService.save(question);	 
		}
		return INDEX;
	}
	
	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	
}
