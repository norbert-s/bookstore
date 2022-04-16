package com.norbert.susztek.bookstore.controller;


import com.norbert.susztek.bookstore.entity.Book;
import com.norbert.susztek.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @GetMapping("/books")
//    public List<Book> findAll(){
//        return bookService.findAll();
//    }
    @GetMapping("/")
    public String getDefault(){
        //return "redirect:/books";
        //return new RedirectView("/books");
        return "books/index";
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        System.out.println("itt vagyunk");
        List<Book> theBooks=bookService.findAll();
        model.addAttribute("list_of_books",theBooks);
        return "books/list_of_books_view";
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findAllByTitle(@PathVariable String title){
        return bookService.findAllByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> findAllByAuthor(@PathVariable String author){
        return bookService.findAllByAuthor(author);
    }

//    @PostMapping("/books")
//    public Book addBook(@RequestBody Book theBook){
//        theBook.setId(0);
//        bookService.save(theBook);
//        return theBook;
//    }







//    @PostMapping("/Books")
//    public Book addBook(@RequestBody Book theBook){
////        theBook.(0);
//        bookService.save(theBook);
//        return theBook;
//    }


}
