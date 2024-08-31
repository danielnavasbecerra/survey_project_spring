package com.survey.survey.chapter.domain.entities;

import java.util.List;

import com.survey.survey.at.domain.entities.CreatedUpdatedTime;
import com.survey.survey.questions.domain.entities.Question;
import com.survey.survey.surveys.domain.entities.Survey;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapters")
public class Chapter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToMany(mappedBy = "chapters")
    private List<Question> questions;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String chapterNumber;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String chapterTitle;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String componenthtml;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String componentreact;
}
