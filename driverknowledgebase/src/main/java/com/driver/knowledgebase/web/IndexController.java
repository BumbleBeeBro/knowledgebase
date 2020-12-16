package com.driver.knowledgebase.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.driver.knowledgebase.jpa.author.Author;
import com.driver.knowledgebase.jpa.author.AuthorRepository;
import com.driver.knowledgebase.jpa.paper.Paper;
import com.driver.knowledgebase.jpa.paper.PaperRepository;
import com.driver.knowledgebase.service.Keywords;
import com.driver.knowledgebase.web.webforms.CodebookWebForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.java.Log;

@Controller
@Log
public class IndexController {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private Keywords keywords;

    @Autowired
    private AuthorRepository authorRepository;

    private String[] keywordsStatic = {"crisis management","emergency management","disaster relief","humanitarian operation",
        "disaster management","disaster response","simulation","serious game","exercise","game","test"," trial","experiment","training",
        "innovation","software","algorithm","decision support","tool","solution","process","organization","partnership"};

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/results")
    public String results(Model model) {

        Collection<Paper> papers = paperRepository.findAll();

        model.addAttribute("papers", papers);

        model.addAttribute("keywords", keywordsStatic);
        return "results";
    }

    @RequestMapping("/results/authors/{id}")
    public String authorResults(@PathVariable Long id, Model model) {

        Author author = authorRepository.getOne(id);

        model.addAttribute("author", author);

        List<Paper> papers = new ArrayList<Paper>();

        author.getAuthorPapers().forEach(authorPaper -> {
            papers.add(authorPaper.getPapers());
        });;

        model.addAttribute("papers", papers);

        

        model.addAttribute("keywords", keywordsStatic);
        return "author";
    }

    @RequestMapping("/results/{id}")
    public String result(@PathVariable Long id, Model model) {

        Paper paper = paperRepository.getOne(id);

        model.addAttribute("paper", paper);
        model.addAttribute("keywords", keywords.getKeywords(paper));

        return "result";
    }

    @PostMapping("/change_codebook/{id}")
    public String changeCodebook(@PathVariable Long id, CodebookWebForm codebookWebForm) {

        Paper paper = paperRepository.getOne(id);

        paper.setComment(codebookWebForm.getComment());
        paper.setObjectives(codebookWebForm.getObjectives());
        paper.setResearchQuestions(codebookWebForm.getResearchQuestions());
        paper.setExperimentPlanningAndDeviations(codebookWebForm.getExperimentPlanningAndDeviations());
        paper.setResearchMethods(codebookWebForm.getResearchMethods());
        paper.setMetricsAndKPIs(codebookWebForm.getMetricsAndKPIs());
        paper.setDataCollectionPlan(codebookWebForm.getDataCollectionPlan());
        paper.setDataAnalysis(codebookWebForm.getComment());
        paper.setEthicalProcedures(codebookWebForm.getEthicalProcedures());
        paper.setResults(codebookWebForm.getResults());
        paper.setMethodologicalLL(codebookWebForm.getMethodologicalLL());

        paperRepository.save(paper);

        return "redirect:/results/" + id;
    }

    /**
     * Full text search, concatinates all attributes and searches in them for a string.
     * @param searchString
     * @param model
     * @return
     */
    @GetMapping("/search")
    public String changeCodebook(@RequestParam(value = "searchString") String searchString, Model model) {

        List<Paper> papers = new ArrayList<Paper>();

        paperRepository.findAll().forEach(paper -> {
            String searchspace = paper.toSearchString();

            if (searchspace.contains(searchString.toLowerCase())) {
                log.info(searchspace);
                papers.add(paper);
            }
        });

        model.addAttribute("papers", papers);

        model.addAttribute("keywords", keywordsStatic);


        return "results";
    }
}