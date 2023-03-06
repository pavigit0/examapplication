package com.online.exam.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.online.exam.dto.QuestionsDetail;
import com.online.exam.entity.Questions;

@Component
public class QuestionsUtil {

	public QuestionsDetail toDetails(Questions ques) {
		QuestionsDetail details = null;
		details = new QuestionsDetail(ques.getQuestionId(), ques.getQuestion(), 
				ques.getOption1(), ques.getOption2(),ques.getOption3(),ques.getOption4(),ques.getCorrectAns());
		return details;
	}

	public List<QuestionsDetail> toDetails(List<Questions> quesList) {
		List<QuestionsDetail> details = new ArrayList<>();
		for (Questions question : quesList) {
			QuestionsDetail q = toDetails(question);
			details.add(q);
		}		
		return details;
	}

}
