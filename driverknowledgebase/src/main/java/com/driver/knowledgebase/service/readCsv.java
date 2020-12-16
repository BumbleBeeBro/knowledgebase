package com.driver.knowledgebase.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.Line;

import com.driver.knowledgebase.jpa.author.Author;
import com.driver.knowledgebase.jpa.author.AuthorRepository;
import com.driver.knowledgebase.jpa.author_paper.AuthorPaper;
import com.driver.knowledgebase.jpa.author_paper.AuthorPaperRepository;
import com.driver.knowledgebase.jpa.paper.Paper;
import com.driver.knowledgebase.jpa.paper.PaperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;

import lombok.extern.java.Log;

/**
 * Class to populate the database that stores cities that we focus on (currently
 * not used).
 */
@Component
@Log
public class readCsv implements ApplicationRunner {

	@Autowired
	private PaperRepository paperRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorPaperRepository authorPaperRepository;

	/**
	 * Function to store cities in the city table of the database.
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {

		//TODO uncomment
		if (paperRepository.findAll().isEmpty()) {

			log.info("reading CSV file");

			File file = new File("driverknowledgebase\\src\\main\\resources\\csvs\\paper1.csv");

			InputStream inputFile = new FileInputStream(file);

			BufferedReader br = new BufferedReader(new InputStreamReader(inputFile));

			br.lines().skip(1).forEach((line) -> {
				String[] lineAsString = line.split("\\|");

				// for (String cell : lineAsString) {
				// if (cell == null) {
				// cell = "0";
				// } else {
				// cell.trim();
				// }
				// }

				// log.info(Arrays.toString(lineAsString));

				paperRepository.save(new Paper(lineAsString));

			});


			//transform data
			paperRepository.findAll().forEach(paper -> {
				//delete spaces
				paper.setAuthor(paper.getAuthor().replace(" ; ", "; "));

				//make keyword seperators to kommas
				paper.setKeywords(paper.getKeywords().replace(";", ", "));

				//change pdf link
				paper.setPdfLink("/paper/" + paper.getOfficialId() + ".pdf");

				//change codebook link
				try {
					paper.setCodebookLink("/codebooks/" + paper.getCodebookLink().substring(42));
				} catch (Exception e) {
					log.info(paper.getCodebookLink());
				}

				//save the updated row
				paperRepository.save(paper);
			});

			paperRepository.findAll().forEach(paper -> {
				String[] authors = paper.getAuthor().split(";");

				for (String author : authors) {

					author = author.trim();

					Author newAuthor = authorRepository.save(new Author(author));

					authorPaperRepository.save(new AuthorPaper(paper, newAuthor));

				}

			});

		}
	}

}