package com.driver.knowledgebase.jpa.paper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for the JPA repository CityRepository. (currently not needed)
 */
@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {

}