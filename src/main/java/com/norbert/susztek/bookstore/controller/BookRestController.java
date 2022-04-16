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

    @GetMapping("/")
    public String getDefault(){
        //return "redirect:/books";
        //return new RedirectView("/books");
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> theBooks=bookService.findAll();
        model.addAttribute("list_of_books",theBooks);
        return "books/list_of_books_view";
    }

    @GetMapping("/orderbyauthor")
    public String listBooksOrderByAuthor(Model model){
        List<Book> theBooks=bookService.findAllByOrderByAuthor();
        model.addAttribute("list_of_books",theBooks);
        return "books/list_of_books_view";
    }

    @GetMapping("/orderbytitle")
    public String listBooksOrderByTitle(Model model){
        List<Book> theBooks=bookService.findAllByOrderByTitle();
        model.addAttribute("list_of_books",theBooks);

        return"books/list_of_books_view";
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findAllByTitle(@PathVariable String title){
        return bookService.findAllByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> findAllByAuthor(@PathVariable String author){
        return bookService.findAllByAuthor(author);
    }

    @GetMapping("/books/showUpdateForm")
    public String showUpdateFormk(@RequestParam("bookId")int theId,Model theModel){
        Book theBook = bookService.findById(theId);
        theModel.addAttribute("book",theBook);
        return "books/new-or-update-form";
    }

    @PostMapping(path="/books/update",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateBook(@ModelAttribute("book") Book theBook){
        bookService.save(theBook);
        return "redirect:/books";
    }
    @GetMapping("/books/showCreateForm")
    public String showCreateForm(Model theModel){
        Book theBook = new Book();

        theModel.addAttribute("book",theBook);

        return "books/new-or-update-form";
    }
}
