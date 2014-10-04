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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.eveloso.gasked.jetty.domain.Question;
import br.com.eveloso.gasked.jetty.dto.PlayerDTO;
import br.com.eveloso.gasked.jetty.dto.QuestionBuilder;
import br.com.eveloso.gasked.jetty.service.MatchService;

@Controller
public class MatchController {

	@Autowired
	private MatchService matchService;

	private static Set<Integer> numeros = new TreeSet<Integer>(); 
	
	@RequestMapping(value="/{" + "playerId" + "}")
	@ResponseBody
	public List<PlayerDTO> initGame(@MatrixVariable(pathVar="playerId") Map<String, LinkedList> jogadores) {
		numeros = (numeros.size() > 50) ? new TreeSet<Integer>() : numeros;
		List<PlayerDTO> players = new ArrayList<PlayerDTO>();
		for(String key : jogadores.keySet()){
				PlayerDTO playerDTO = new PlayerDTO();
				playerDTO.setName((String) jogadores.get(key).get(0));
				playerDTO.setQuestions(QuestionBuilder.build(getRandomQuestions(10))); 
				players.add(playerDTO);
		}	
		return players;
	}
	
	private Set<Question> getRandomQuestions(Integer maxResults){
		Set<Question> response = new TreeSet<Question>();
		while (response.size() < maxResults) {
			try {
				int randomize = numeros.size() >= 50 ? complete() : randomize();
				Question question = matchService.getQuestionById(randomize); 
				response.add(question);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(numeros); 
		return response;
	}
	
	private int complete(){
		int numero = 1;
		for (int i = 1; i < 60; i++) {
			if(numeros.contains(i))
				continue;
			else {
				numeros.add(i);
				return i;
			}
		}
		return numero;
	}
	
	private static int randomize(){
		Integer numero = null;
		while(true){
			numero = new Random().nextInt(60);
			if(numero == 0 || numeros.contains(numero))
				continue;
			else {
				numeros.add(numero);
				break;
			}
		}
		return numero;
	}
	

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}
}
