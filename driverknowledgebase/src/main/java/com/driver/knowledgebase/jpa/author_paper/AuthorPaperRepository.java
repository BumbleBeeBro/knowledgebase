package com.driver.knowledgebase.jpa.author_paper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for the JPA repository CityRepository. (currently not needed)
 */
@Repository
public interface AuthorPaperRepository extends JpaRepository<AuthorPaper, Long> {

}