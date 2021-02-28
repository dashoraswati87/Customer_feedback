/**
 * 
 */
package com.demo.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.survey.exception.HelpNowException;
import com.demo.survey.model.SurveyConfig;
import com.demo.survey.model.SurveyResponse;
import com.demo.survey.service.SurveyConfigService;

/**
 * @author hp
 *
 */
@RestController
@RequestMapping("/api")
public class SurveyController {

	@Autowired
	private SurveyConfigService surveyConfigService;

	@PostMapping("/create/survey")
	public ResponseEntity<SurveyConfig> createSurvey(@RequestBody SurveyConfig surveyConfig,
			@RequestParam String userType) throws HelpNowException {

		SurveyConfig surveyConfigData = surveyConfigService.createSurvey(surveyConfig, userType);
		return new ResponseEntity<>(surveyConfigData, HttpStatus.CREATED);

	}

	@GetMapping("/surveys")
	public ResponseEntity<List<SurveyConfig>> getSurveysForRespondent(@RequestParam long userId) {

		try {
			List<SurveyConfig> surveyConfigList = surveyConfigService.getSurveysForRespondent(userId);
			return new ResponseEntity<>(surveyConfigList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/save/survey")
	public ResponseEntity<SurveyResponse> createSurvey(@RequestBody SurveyResponse surveyResponse) throws HelpNowException {

		SurveyResponse surveyResponseData = surveyConfigService.saveSurvey(surveyResponse);
		return new ResponseEntity<>(surveyResponseData, HttpStatus.CREATED);

	}

}
