/**
 * 
 */
package com.demo.survey.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.survey.model.SurveyResponse;

/**
 * @author hp
 *
 */
public interface SurveyResponseRepository extends MongoRepository<SurveyResponse, String> {

	SurveyResponse findBySurveyConfigIdAndUserId(long surveyConfigId, long userId);

}