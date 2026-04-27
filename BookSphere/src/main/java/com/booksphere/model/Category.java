package com.booksphere.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/** A genre / subject category that books can be tagged with. */
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(length = 255)
    private String description;

    // ── Getters / Setters ────────────────────────────────────────────────────

    public Long   getId()                    { return id; }
    public void   setId(Long id)             { this.id = id; }

    public String getName()                  { return name; }
    public void   setName(String name)       { this.name = name; }

    public String getDescription()           { return description; }
    public void   setDescription(String d)   { this.description = d; }
}