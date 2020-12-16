package com.driver.knowledgebase.jpa.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for the JPA repository CityRepository. (currently not needed)
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}