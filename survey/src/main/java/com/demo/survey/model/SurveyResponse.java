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
@Document(collection = "SurveyResponse")
public class SurveyResponse {
	
	@Id
	private String id;
	private long userId;	
	private long surveyConfigId;
	// ( this field stores two status (SUBMITTED, UPDATED)
	private String surveyStatus;	
	private SurveyConfig surveyConfig = new SurveyConfig();
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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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
	 * @return the surveyStatus
	 */
	public String getSurveyStatus() {
		return surveyStatus;
	}
	/**
	 * @param surveyStatus the surveyStatus to set
	 */
	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}
	/**
	 * @return the surveyConfig
	 */
	public SurveyConfig getSurveyConfig() {
		return surveyConfig;
	}
	/**
	 * @param surveyConfig the surveyConfig to set
	 */
	public void setSurveyConfig(SurveyConfig surveyConfig) {
		this.surveyConfig = surveyConfig;
	}
	
	
	
	
	

}
