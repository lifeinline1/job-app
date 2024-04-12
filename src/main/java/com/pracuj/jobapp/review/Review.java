package com.pracuj.jobapp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pracuj.jobapp.company.Company;
import com.pracuj.jobapp.job.Job;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String content;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Review() {
    }

    public Review(Long id, String title, String author, String content, Company company) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
