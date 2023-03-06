package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exam.dao.QuestionBankDao;
import com.online.exam.entity.QuestionBank;



@Service
public class QuestionBankServiceImpl implements QuestionBankService{
	
	@Autowired
	private QuestionBankDao QuesBDao;

	@Override
	public QuestionBank add(QuestionBank questionbank) {
		QuestionBank question = QuesBDao.save(questionbank);
		return question;
	}

	@Override
	public QuestionBank deleteQuestionBank(Integer quesbankid) {
		QuestionBank ques = deleteQuestionBank(quesbankid);
		QuesBDao.deleteById(quesbankid);
		return ques;
		
	}

	@Override
	public QuestionBank editQuestionbank(QuestionBank quesB) {
		boolean exists=QuesBDao.existsById(quesB.getQuesbankid());
        if(!exists){
      
           // throw new QuestionBankNotFoundException("questionbank doesn't exists for id="+quesB.getQuesId());
        }
		return QuesBDao.save(quesB);
	}

	

	@Override
	public List<QuestionBank> showQuestionbank() {
		List<QuestionBank> quesbankList = QuesBDao.findAll();
		return quesbankList;
	}


	@Override
	public QuestionBank findByquesbankid(int quesbankid) {
		return QuesBDao.findByquesbankid(quesbankid);
	}

}
