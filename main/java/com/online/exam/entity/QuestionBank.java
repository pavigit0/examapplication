package com.online.exam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="QuestionBank")
public class QuestionBank {
	@Id
	@GeneratedValue
	//@Column(name = "quesbank_id")
	private int quesbankid;
	//@Column(name = "ques_id")
	private int quesid;
	//@Column(name = "question")
	private String question;
	//@Column(name = "subject")
	private String answer;
	
//	@ManyToOne
//	@JoinColumn(name="ques_id")
//	private Questions ques;
	
	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionBank(int quesbankid, int quesid, String question, String answer) {
		super();
		this.quesbankid = quesbankid;
		this.quesid = quesid;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QuestionBank [quesbankid=" + quesbankid + ", quesid=" + quesid + ", question=" + question + ", answer=" + answer + "]";
	}
	public int getQuesid() {
		return quesid;
	}
	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQuesbankid() {
		return quesbankid;
	}

	public void setQuesbankid(int quesbankid) {
		this.quesbankid = quesbankid;
	}

	public String getquestionbankid() {
//		// TODO Auto-generated method stub
		return null;
	}
	

}
