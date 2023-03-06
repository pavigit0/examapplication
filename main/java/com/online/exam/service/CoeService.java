package com.online.exam.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.online.exam.entity.Questions;


@Service
public interface CoeService {
Questions add(Questions ques);

	
	Questions deleteQuestions(Integer qId);
	
	Questions editQuestions(Questions ques);
	
	List<Questions> showQuestions();


	


	Questions findByquestionId(int questionId);


	
}