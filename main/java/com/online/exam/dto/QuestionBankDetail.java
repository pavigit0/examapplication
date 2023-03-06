package com.online.exam.dto;

public class QuestionBankDetail {
	private int quesbankid;
	private int quesid;
	private String question;
	private String answer;
	public QuestionBankDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionBankDetail(int quesbankid, int quesid, String question, String answer) {
		super();
		this.quesbankid = quesbankid;
		this.quesid = quesid;
		this.question = question;
		this.answer =answer;
	}
	@Override
	public String toString() {
		return "QuestionBankDetail [quesbankid=" + quesbankid + ", quesid=" + quesid + ", question=" + question
				+ ", answer=" + answer + "]";
	}
	public int getQuesbankid() {
		return quesbankid;
	}
	public void setQuesbankid(int quesbankid) {
		this.quesbankid = quesbankid;
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
	public void setSubject(String answer) {
		this.answer = answer;
	}
	

}
