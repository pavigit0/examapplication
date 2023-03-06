package com.online.exam.service;

import java.util.List;

import com.online.exam.entity.QuestionBank;


public interface QuestionBankService {

	QuestionBank add(QuestionBank questionbank);

	QuestionBank deleteQuestionBank(Integer quesbankid);

	QuestionBank editQuestionbank(QuestionBank quesB);

	

	List<QuestionBank> showQuestionbank();

	QuestionBank findByquesbankid(int quesbankid);

}
