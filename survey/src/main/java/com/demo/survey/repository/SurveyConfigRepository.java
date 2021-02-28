/**
 * 
 */
package com.demo.survey.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.survey.model.SurveyConfig;

/**
 * @author hp
 *
 */
public interface SurveyConfigRepository extends MongoRepository<SurveyConfig, String> {

	SurveyConfig findBySurveyName(String surveyName);
	List<SurveyConfig> findByGenderAndAgeGroup(String gender, String ageGroup);

}
