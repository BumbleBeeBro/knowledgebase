package com.driver.knowledgebase.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.driver.knowledgebase.jpa.paper.Paper;
import com.driver.knowledgebase.jpa.paper.PaperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.cortical.retina.client.LiteClient;
import lombok.extern.java.Log;

@Component
@Log
public class Keywords {

	@Value("cortical.key")
	private String corticalKey;


    @Autowired
    private PaperRepository paperRepository;
    
    public List<String> getKeywords( Collection<Paper> papers) {

        String text = "";

        for (Paper paper : papers) {
            text += " " + paper.getKeywords() + " ";
            //text += " " + paper.getPaperAbstract() + " ";
		}
		
		log.warning("Key=" + corticalKey);

        LiteClient lite = new io.cortical.retina.client.LiteClient(corticalKey);

        List<String> keywords = null;

        try {
            keywords = lite.getKeywords(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return keywords;

    }

    public List<String> getKeywords(Paper paper) {

        String text = "";

        text += " " + paper.getKeywords() + " ";
		text += " " + paper.getPaperAbstract() + " ";
		
		log.warning("Key=" + corticalKey);

        LiteClient lite = new io.cortical.retina.client.LiteClient(corticalKey);

        List<String> keywords = null;

        try {
            keywords = lite.getKeywords(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return keywords;

    }
    

}