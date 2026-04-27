package com.booksphere.controller;

import com.booksphere.model.Book;
import com.booksphere.model.Category;
import com.booksphere.services.AuthorService;
import com.booksphere.services.BookService;
import com.booksphere.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired private BookService     bookService;
    @Autowired private AuthorService   authorService;
    @Autowired private CategoryService categoryService;

    @GetMapping
    public String list(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                       @RequestParam(name = "page",    defaultValue = "1") int page,
                       @RequestParam(name = "pageSize",defaultValue = "10") int pageSize,
                       Model model) {

        long total = bookService.count(keyword);
        model.addAttribute("books",       bookService.findAll(keyword, page, pageSize));
        model.addAttribute("keyword",     keyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize",    pageSize);
        model.addAttribute("totalPages",  (int) Math.ceil((double) total / pageSize));
        model.addAttribute("totalCount",  total);
        model.addAttribute("activePage",  "books");
        return "books/list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("book",       new Book());
        model.addAttribute("authors",    authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("activePage", "books");
        return "books/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book",       bookService.findById(id));
        model.addAttribute("authors",    authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("activePage", "books");
        return "books/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("book") Book book,
                       BindingResult bindingResult,
                       @RequestParam(name = "categoryIds", required = false) List<Long> categoryIds,
                       @RequestParam(name = "authorId",    required = false) Long authorId,
                       Model model,
                       RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("authors",    authorService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("activePage", "books");
            return "books/form";
        }

        // Wire up the author relationship
        if (authorId != null) book.setAuthor(authorService.findById(authorId));

        // Wire up the many-to-many categories
        if (categoryIds != null && !categoryIds.isEmpty()) {
            HashSet<Category> selected = new HashSet<>();
            categoryIds.forEach(cid -> selected.add(categoryService.findById(cid)));
            book.setCategories(selected);
        }

        bookService.save(book);
        redirectAttributes.addFlashAttribute("successMessage", "Book '" + book.getTitle() + "' saved.");
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Book deleted.");
        return "redirect:/books";
    }
}