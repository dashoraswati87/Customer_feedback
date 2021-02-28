package com.demo.survey.model;

public class SurveyQuestion {
	
	private long questionId;
	private String question;
	private String questionResponse;
	/**
	 * @return the questionId
	 */
	public long getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the questionResponse
	 */
	public String getQuestionResponse() {
		return questionResponse;
	}
	/**
	 * @param questionResponse the questionResponse to set
	 */
	public void setQuestionResponse(String questionResponse) {
		this.questionResponse = questionResponse;
	}
	
	

}
