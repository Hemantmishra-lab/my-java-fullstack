package com.booksphere.controller;

import com.booksphere.model.Author;
import com.booksphere.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired private AuthorService authorService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors",    authorService.findAll());
        model.addAttribute("activePage", "authors");
        return "authors/list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("author",     new Author());
        model.addAttribute("activePage", "authors");
        return "authors/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("author",     authorService.findById(id));
        model.addAttribute("activePage", "authors");
        return "authors/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("author") Author author,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) { model.addAttribute("activePage", "authors"); return "authors/form"; }
        authorService.save(author);
        redirectAttributes.addFlashAttribute("successMessage", "Author '" + author.getName() + "' saved.");
        return "redirect:/authors";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Author a = authorService.findById(id);
        authorService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Author deleted.");
        return "redirect:/authors";
    }
}