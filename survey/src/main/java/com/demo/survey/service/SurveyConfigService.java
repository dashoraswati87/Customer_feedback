/**
 * 
 */
package com.demo.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.survey.exception.HelpNowException;
import com.demo.survey.model.SurveyConfig;
import com.demo.survey.model.SurveyResponse;
import com.demo.survey.model.User;
import com.demo.survey.repository.SurveyConfigRepository;
import com.demo.survey.repository.SurveyResponseRepository;
import com.demo.survey.repository.UserRepository;

/**
 * @author hp
 *
 */
@Service
public class SurveyConfigService {

	@Autowired
	private SurveyConfigRepository surveyConfigRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SurveyResponseRepository surveyResponseRepo;

	/**
	 * 
	 * @param surveyConfig
	 * @param userType     (passed this parameter just for testing, in real
	 *                     implementation we will get userType of logged in user)
	 * @return
	 * @throws Exception
	 */
	public SurveyConfig createSurvey(SurveyConfig surveyConfig, String userType) throws HelpNowException {

		try {
			if (surveyConfig != null) {

				// Check if Survey already exists in the system with same name.
				SurveyConfig existingSurveyConfig = surveyConfigRepo.findBySurveyName(surveyConfig.getSurveyName());
				if (existingSurveyConfig != null) {

					throw new HelpNowException("Survey with the same name is already configured");
				}
				// throw exception if user is not coordinator
				else if (!userType.equalsIgnoreCase("COORDINATOR")) {
					throw new HelpNowException("Please login as coordinator to configure survey. ");
				} else {

					surveyConfig = surveyConfigRepo.save(surveyConfig);
				}

			}
		} catch (Exception e) {
			throw new HelpNowException(e.getMessage());
		}
		return surveyConfig;

	}

	/**
	 * 
	 * @param userId (this parameter will no longer needed as we will get loggedin user in future
	 * @return
	 */
	public List<SurveyConfig> getSurveysForRespondent(long userId) {

		// get user details by userId
		User user = userRepo.findByUserId(userId);
		List<SurveyConfig> surveyConfigList = null;
		if(user != null) {
		String ageGroup = getAgeGroup(user.getAge());
		surveyConfigList = surveyConfigRepo.findByGenderAndAgeGroup(user.getGender(), ageGroup);
		}
		
		return surveyConfigList;

	}

	/**
	 * This method saves the responses from Respondent (update if document already exists in collection)
	 * @param surveyName
	 * @return SurveyResponse
	 * @throws Exception
	 */
	public SurveyResponse saveSurvey(SurveyResponse SurveyResponse) throws HelpNowException {
		
		SurveyResponse newSurveyResponse = null;
		try {
			
			SurveyResponse existingSurveyResponse = surveyResponseRepo.findBySurveyConfigIdAndUserId(SurveyResponse.getSurveyConfigId(), SurveyResponse.getUserId());
			
		 if(existingSurveyResponse != null) {
			 existingSurveyResponse.setSurveyConfig(SurveyResponse.getSurveyConfig());
			 existingSurveyResponse.setSurveyStatus("UPDATED");
			 newSurveyResponse = surveyResponseRepo.save(existingSurveyResponse);
		 }
		 else {
			 
			SurveyResponse.setSurveyStatus("SUBMITTED");
			newSurveyResponse = surveyResponseRepo.save(SurveyResponse);
		 }
			

		} catch (Exception e) {
			throw new HelpNowException(e.getMessage());
		}
		return newSurveyResponse;

	}

	/**
	 * This method calculates ageGroup based on user's age
	 * 
	 * @param age
	 * @return ageGroup
	 */
	public String getAgeGroup(long age) {

		String ageGroup = "";

		if (age <= 18)
			ageGroup = "MINOR";
		else if (age > 18 && age <= 36)
			ageGroup = "ADULT";
		else if (age > 36 && age <= 50)
			ageGroup = "MIDDLE_AGE";
		else
			ageGroup = "OLD_AGE";

		return ageGroup;
	}

}
