package br.com.eveloso.gasked.jetty.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.eveloso.gasked.jetty.domain.Alternative;
import br.com.eveloso.gasked.jetty.domain.Category;
import br.com.eveloso.gasked.jetty.domain.Question;

public class QuestionBuilder {

	public static List<QuestionDTO> build(List<Question> questions) {
		List<QuestionDTO> response = new ArrayList<QuestionDTO>();
		for (Question question : questions) {
			response.add(build(question)); 
		}
		return response;
	}

	private static QuestionDTO build(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAlternatives(buildAlternatives(question.getAlternatives()));
		questionDTO.setCategory(buildCategory(question.getCategory()));
		questionDTO.setDescription(question.getDescription());
		questionDTO.setId(question.getId());
		return questionDTO;
	}

	private static CategoryDTO buildCategory(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		return dto;
	}

	private static List<AlternativeDTO> buildAlternatives(List<Alternative> alternatives) {
		List<AlternativeDTO> response = new ArrayList<AlternativeDTO>();
		for (Alternative alternative : alternatives) {
			response.add(buildAlternative(alternative));
		}
		return response;
	}

	private static AlternativeDTO buildAlternative(Alternative alternative) {
		AlternativeDTO dto = new AlternativeDTO();
		dto.setId(alternative.getId());
		dto.setResponse(alternative.getResponse());
		dto.setValue(alternative.getValue());
		return dto;
	}
	
}
