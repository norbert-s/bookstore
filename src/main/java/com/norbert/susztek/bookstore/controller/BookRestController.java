package com.norbert.susztek.bookstore.controller;


import com.norbert.susztek.bookstore.entity.Book;
import com.norbert.susztek.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
@RequestMapping("/")
public class BookRestController {
    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> theBooks=bookService.findAll();
        model.addAttribute("list_of_books",theBooks);
        return "books/list_of_books_view";
    }

    @PostMapping(path="/books/update",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateBook(@ModelAttribute("book") Book theBook){
        bookService.save(theBook);
        return "redirect:/books";
    }


//    @GetMapping("/books/showUpdateForm2")
//    public String sf(@RequestParam("bookId")int theId,Model theModel){
//        Book theBook = bookService.findById(theId);
//        theModel.addAttribute("book",theBook);
//        return "books/new-or-update-form";
//    }
}
