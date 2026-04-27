package com.booksphere.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200 ,message = "Title cannot exceed 200 characters")
    @Column(nullable = false,length = 200)
    private String title;

    @Size(max = 20,message = "ISBN cannot exceed 20 characters")
    @Column(unique = true,length = 20)
    private String isbn;

    @Min(value = 1000,message = "Publish year seems too old")
    @Max(value=2100,message = "Publish year too far in the future")
    private Integer publishYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Min(value = 0,message = "Available copies cannot be negative")
    @Column(nullable = false)
    private int availableCopies = 1;

    @Min(value = 1,message = "Total copies must be at least 1")
    @Column(nullable = false)
    private int totalCopies = 1;


    //GETTER AND SETTER


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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    @Transient
    public boolean isAvailable() { return availableCopies > 0; }
}
