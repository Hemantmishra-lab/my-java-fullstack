package com.trumio.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Books")
public class Book {
    private String title;
    private String author;
    @Id
    private int isbn;
    @ElementCollection
    @CollectionTable(name = "book_volumes", joinColumns = @JoinColumn(name = "book_id"))
    private List<String> volumes;

    // Default Constructor (Important for Spring)
    public Book() {}

    // Parameterized Constructor
    public Book(String title, String author, int isbn, List<String> volumes) {
        this.title = title;
        this.author = author;

        this.isbn = isbn;
        this.volumes = volumes;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }

    public List<String> getVolumes() { return volumes; }
    public void setVolumes(List<String> volumes) { this.volumes = volumes; }
}