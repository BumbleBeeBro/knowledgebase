// Author	Year	Keywords	Abstract	Journal	Codebook Link	PDF Link	Online Link	Comment	Experiment, exercise, simulation, or trial objectives 	Research questions 	Experiment planning and deviations	Research Methods 	Metrics and Key Performance Indicators (KPIs)	Data collection plan 	Data analysis 	Ethical procedures 	Results 	Methodological LL (Lessons Learned)	

package com.driver.knowledgebase.jpa.paper;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.driver.knowledgebase.jpa.author_paper.AuthorPaper;
import com.driver.knowledgebase.jpa.tags.Tag;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Paper implements Serializable {

    protected static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Tag> tags;

    private Long officialId;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String author;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "papers", cascade = CascadeType.MERGE)
    private Collection<AuthorPaper> authorPapers;

    private int year;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String keywords;

    @Column(name = "abstract", columnDefinition = "TEXT")
    private String paperAbstract;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String journal;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String codebookLink;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String pdfLink;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String onlineLink;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String objectives;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String researchQuestions;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String experimentPlanningAndDeviations;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String researchMethods;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String metricsAndKPIs;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String dataCollectionPlan;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String dataAnalysis;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String ethicalProcedures;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String results;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String methodologicalLL;

    public String toSearchString() {
        String searchstring = "" + 
            getOfficialId() + " " +
            getTitle() + " " +
            getAuthor() + " " +
            getYear() + " " +
            getKeywords() + " " +
            getPaperAbstract() + " " +
            getJournal() + " " +
            getCodebookLink() + " " +
            getPdfLink() + " " +
            getOnlineLink() + " " +
            getComment() + " " +
            getObjectives() + " " +
            getResearchQuestions() + " " +
            getExperimentPlanningAndDeviations() + " " +
            getResearchMethods() + " " +
            getMetricsAndKPIs() + " " +
            getDataCollectionPlan() + " " +
            getDataAnalysis() + " " +
            getEthicalProcedures() + " " +
            getResults() + " " +
            getMethodologicalLL();

        return searchstring.toLowerCase();
    }

    public Paper(String[] array) {
        super();
        try {
            this.officialId = Long.parseLong(array[0]);
        } catch (Exception e) {
            this.officialId = Long.parseLong("0");
        }

        try {
            this.title = array[1];
        } catch (Exception e) {
            this.title = "0";
        }

        try {
            this.author = array[2];
        } catch (Exception e) {
            this.author = "0";
        }

        try {
            this.year = Integer.parseInt(array[3]);
        } catch (Exception e) {
            this.year = Integer.parseInt("0");
        }

        try {
            this.keywords = array[4];
        } catch (Exception e) {
            this.keywords = "0";
        }

        try {
            this.paperAbstract = array[5];
        } catch (Exception e) {
            this.paperAbstract = "0";
        }

        try {
            this.journal = array[6];
        } catch (Exception e) {
            this.journal = "0";
        }

        // change this later
        try {
            this.codebookLink = array[7];
        } catch (Exception e) {
            this.codebookLink = "0";
        }

        // change this later
        this.pdfLink = array[8];
        try {
            this.onlineLink = array[9];
        } catch (Exception e) {
            this.onlineLink = "0";
        }

        try {
            this.comment = array[10];
        } catch (Exception e) {
            this.comment = "0";
        }

        try {
            this.objectives = array[11];
        } catch (Exception e) {
            this.objectives = "0";
        }

        try {
            this.researchQuestions = array[12];
        } catch (Exception e) {
            this.researchQuestions = "0";
        }

        try {
            this.experimentPlanningAndDeviations = array[13];
        } catch (Exception e) {
            this.experimentPlanningAndDeviations = "0";
        }

        try {
            this.researchMethods = array[14];
        } catch (Exception e) {
            this.researchMethods = "0";
        }

        try {
            this.metricsAndKPIs = array[15];
        } catch (Exception e) {
            this.metricsAndKPIs = "0";
        }

        try {
            this.dataCollectionPlan = array[16];
        } catch (Exception e) {
            this.dataCollectionPlan = "0";
        }

        try {
            this.dataAnalysis = array[17];
        } catch (Exception e) {
            this.dataAnalysis = "0";
        }

        try {
            this.ethicalProcedures = array[18];
        } catch (Exception e) {
            this.ethicalProcedures = "0";
        }

        try {
            this.results = array[19];
        } catch (Exception e) {
            this.results = "0";
        }

        try {
            this.methodologicalLL = array[20];
        } catch (Exception e) {
            this.methodologicalLL = "0";
        }

    }

}
