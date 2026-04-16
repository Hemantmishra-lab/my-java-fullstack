package com.trumio.controller;

//Model Class: Book.java (Fields: title, author, isbn, Volumes) -> Controller: BookController.java -> View (Input): add-book-form.jsp -> View (Output): book-confirmation.jsp

import com.trumio.Service.BookServices;
import com.trumio.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookServices bookServices;

    //Opens the Form
    @RequestMapping("/bookBooking")
    public String showForm() {
        return "add-book-form";
    }

    // Process the Form
    @RequestMapping(value = "/processBookingbook", method = RequestMethod.POST)
    public String handleForm(
            @RequestParam("sTitle") String title,
            @RequestParam("sAuthor") String author,
            @RequestParam("sISBN") int isbn,
            @RequestParam("sVolume") List<String> volumes,
            Model model
    ) {

        Book bookObj = new Book(title, author, isbn, volumes);

        bookServices.registerBooks(bookObj);

        //Add with model so that jsp can use
        model.addAttribute("bk", bookObj);

        return "book-confirmation";
    }
}