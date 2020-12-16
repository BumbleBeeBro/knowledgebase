package com.driver.knowledgebase.jpa.author_paper;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.driver.knowledgebase.jpa.author.Author;
import com.driver.knowledgebase.jpa.paper.Paper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorPaper implements Serializable {

    protected static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Paper papers;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author authors;

    public AuthorPaper(Paper papers, Author authors) {
        this.papers = papers;
        this.authors = authors;
    }
}  