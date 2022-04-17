package com.norbert.susztek.bookstore.controller;

import com.norbert.susztek.bookstore.entity.Book;
import com.norbert.susztek.bookstore.service_book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BookRestShowFormsController {
    BookService bookService;

    @Autowired
    public BookRestShowFormsController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("/books/showCreateForm")
    public String showCreateForm(Model theModel){
        Book theBook = new Book();

        theModel.addAttribute("book",theBook);

        return "newbook/newbook";
    }
    @GetMapping("/books/showUpdateForm")
    public String showUpdateForm(@RequestParam("bookId")int theId, Model theModel){
        Book theBook = bookService.findById(theId);
        theModel.addAttribute("book",theBook);
        return "newbook/newbook";
    }
    @GetMapping("/books/showDeleteForm")
    public String showDeleteForm(@RequestParam("bookId") int theId, Model theModel){
        Book theBook = bookService.findById(theId);

        theModel.addAttribute("book",theBook);

        return "delete/delete";
    }
}
