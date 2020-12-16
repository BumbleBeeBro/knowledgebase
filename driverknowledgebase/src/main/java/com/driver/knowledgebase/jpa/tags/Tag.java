package com.driver.knowledgebase.jpa.tags;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.driver.knowledgebase.jpa.paper.Paper;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tag
 */
@Data
@Entity
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = Paper.class)
    private Paper paper;

    private String property;
}