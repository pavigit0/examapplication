package com.online.exam.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.online.exam.dto.QuestionBankDetail;
import com.online.exam.entity.QuestionBank;


@Component
public class QuestionBankUtil {

	public static QuestionBankDetail toDetails(QuestionBank QuesB) {
		QuestionBankDetail details = null;
		details = new QuestionBankDetail(QuesB.getQuesbankid(), QuesB.getQuesid(), 
				QuesB.getQuestion(), QuesB.getAnswer());
		return details;
	}

	public static List<QuestionBankDetail> toDetails(List<QuestionBank> QuesBList) {
		List<QuestionBankDetail> details = new ArrayList<>();
		for (QuestionBank questionbank : QuesBList) {
			QuestionBankDetail QuesB = toDetails(questionbank);
			details.add(QuesB);
		}		
		return details;
	}

}
