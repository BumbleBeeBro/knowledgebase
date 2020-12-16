package com.driver.knowledgebase.web.webforms;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CodebookWebForm implements Serializable {

        //TODO needs validation
    
        protected static final long serialVersionUID = 42L;
    
        private String comment;
    
        private String objectives;
    
        private String researchQuestions;
    
        private String experimentPlanningAndDeviations;
    
        private String researchMethods;
    
        private String metricsAndKPIs;
    
        private String dataCollectionPlan;
    
        private String dataAnalysis;
    
        private String ethicalProcedures;
    
        private String results;
    
        private String methodologicalLL;
}