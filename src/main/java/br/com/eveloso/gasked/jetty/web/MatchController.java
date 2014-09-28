/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.eveloso.gasked.jetty.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.eveloso.gasked.jetty.domain.Alternative;
import br.com.eveloso.gasked.jetty.domain.Category;
import br.com.eveloso.gasked.jetty.domain.Question;
import br.com.eveloso.gasked.jetty.service.MatchService;

@Controller
public class MatchController {

	@Autowired
	private MatchService matchService;

	@RequestMapping("/{jogador}")
	@ResponseBody
	public String helloWorld(@PathVariable(value="jogador") String jogadores) {
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
//		matchService.save(question);
		
		
		List<Question> questions = matchService.getQuestions();
		return questions.toString() +" -  "+ jogadores;
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}
}
