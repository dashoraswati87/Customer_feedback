/**
 * 
 */
package com.demo.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hp
 *
 */
@Document(collection = "surveyConfig")
public class SurveyConfig {

	@Id
	private String id;
	private long surveyConfigId;
	private String surveyName;
	private String gender;
	private String ageGroup;
	private SurveyQuestion[] surveyQuestions = new SurveyQuestion[0];
	
	//Default Constructor  
	public SurveyConfig() {
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the surveyConfigId
	 */
	public long getSurveyConfigId() {
		return surveyConfigId;
	}

	/**
	 * @param surveyConfigId the surveyConfigId to set
	 */
	public void setSurveyConfigId(long surveyConfigId) {
		this.surveyConfigId = surveyConfigId;
	}

	/**
	 * @return the surveyName
	 */
	public String getSurveyName() {
		return surveyName;
	}

	/**
	 * @param surveyName the surveyName to set
	 */
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the ageGroup
	 */
	public String getAgeGroup() {
		return ageGroup;
	}

	/**
	 * @param ageGroup the ageGroup to set
	 */
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	/**
	 * @return the surveyQuestions
	 */
	public SurveyQuestion[] getSurveyQuestions() {
		return surveyQuestions;
	}

	/**
	 * @param surveyQuestions the surveyQuestions to set
	 */
	public void setSurveyQuestions(SurveyQuestion[] surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Survey Name=" + surveyName + ", Gender=" + gender + ", Age=" + ageGroup + "]";
	}
	
	
}
