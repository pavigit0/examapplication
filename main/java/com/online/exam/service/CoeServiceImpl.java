package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.exam.dao.QuestionDao;
import com.online.exam.entity.Questions;

@Component
@Transactional
public class CoeServiceImpl implements CoeService{
	
@Autowired
private QuestionDao qDao;	

	@Override
	public Questions add(Questions question) {
		Questions ques = qDao.save(question);
		return ques;
	
}

	@Override
	public Questions deleteQuestions(Integer qId) {
		Questions ques= deleteQuestions(qId);
		qDao.deleteById(qId);
		return ques;
	}

	@Override
	public Questions editQuestions(Questions ques) {
		boolean exists=qDao.existsById(ques.getQuestionId());
        if(!exists){
      System.out.println("not found");
           // throw new QuestionNotFoundException("question doesn't exists for id="+ques.getQuestionId());
        }
		return qDao.save(ques);	
	}

	@Override
	public List<Questions> showQuestions() {
		List<Questions> quesList = qDao.findAll();
		return quesList;
	}

	@Override
	public Questions findByquestionId(int questionId) {
		return qDao.findByquestionId(questionId);
	}

	

	

	

	
}


