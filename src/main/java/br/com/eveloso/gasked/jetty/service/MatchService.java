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

package br.com.eveloso.gasked.jetty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eveloso.gasked.jetty.domain.Question;
import br.com.eveloso.gasked.jetty.domain.persistence.jpa.QuestionDAO;

@Service
public class MatchService {
	
	@Autowired 
	private QuestionDAO questionDAO;
	
	public void save(Question question) {
		questionDAO.save(question);
	}
	
	public List<Question> getQuestions(){
		List<Question> all = questionDAO.getAll();
		return all;
	}

	public QuestionDAO getQuestionDAO() {
		return questionDAO;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}


}
