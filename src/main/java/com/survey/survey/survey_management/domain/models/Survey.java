package com.survey.survey.survey_management.domain.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.survey.survey.catalog.domain.entities.CategoriesCatalog;
import com.survey.survey.chapters_management.domain.models.Chapter;
import com.survey.survey.helpers.CreatedUpdatedTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    CreatedUpdatedTime createdUpdatedTime;
    
    @Column (columnDefinition = "VARCHAR(255)", nullable = false)
    private String Description;

    @Column (columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    @ManyToMany
    @JoinTable(
        name = "survey_category",
        joinColumns = @JoinColumn(name = "survey_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoriesCatalog> categoriesCatalogs;

    @Column(columnDefinition = "VARCHAR(20)")
    private String componenthtml;

    @Column(columnDefinition = "VARCHAR(20)")
    private String componentreact;


}
