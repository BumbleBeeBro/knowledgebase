package com.driver.knowledgebase.jpa.author;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.driver.knowledgebase.jpa.author_paper.AuthorPaper;
import com.driver.knowledgebase.jpa.paper.Paper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    protected static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "authors", cascade = CascadeType.MERGE)
    private Collection<AuthorPaper> authorPapers;

    public Author(String name) {
        this.name = name;
    }
}  