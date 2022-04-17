package com.norbert.susztek.bookstore.controller;

import com.norbert.susztek.bookstore.entity.Book;
import com.norbert.susztek.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookRestQueriesController {
    private BookService bookService;
    @Autowired
    public BookRestQueriesController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/orderbyauthor")
    public String listBooksOrderByAuthor(Model model){
        List<Book> theBooks=bookService.findAllByOrderByAuthor();
        model.addAttribute("list_of_books",theBooks);
        return "list/list";
    }

    @GetMapping("/orderbytitle")
    public String listBooksOrderByTitle(Model model){
        List<Book> theBooks=bookService.findAllByOrderByTitle();
        model.addAttribute("list_of_books",theBooks);

        return "list/list";
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findAllByTitle(@PathVariable String title){
        return bookService.findAllByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> findAllByAuthor(@PathVariable String author){
        return bookService.findAllByAuthor(author);
    }
}
