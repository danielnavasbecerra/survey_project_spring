package com.survey.survey.survey_management.application.services;

import java.util.Optional;
import java.util.List;

import com.survey.survey.survey_management.domain.models.Survey;

public interface SurveyService {

    Optional<Survey> findById(Long id);

    List<Survey> findAll();

    Survey save(Survey survey);

    Survey update(Long id, Survey survey);

    void deleteById(Long id);
}
