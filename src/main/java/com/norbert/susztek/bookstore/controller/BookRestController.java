package com.norbert.susztek.bookstore.controller;


import com.norbert.susztek.bookstore.entity.Book;
import com.norbert.susztek.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/")
public class BookRestController {
    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findAllByTitle(@PathVariable String title){
        return bookService.findAllByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> findAllByAuthor(@PathVariable String author){
        return bookService.findAllByAuthor(author);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook){
        theBook.setId(0);
        bookService.save(theBook);
        return theBook;
    }





//    @PostMapping("/Books")
//    public Book addBook(@RequestBody Book theBook){
////        theBook.(0);
//        bookService.save(theBook);
//        return theBook;
//    }


}
