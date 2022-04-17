package com.norbert.susztek.bookstore.controller;


import com.norbert.susztek.bookstore.entity.Book;
import com.norbert.susztek.bookstore.service_book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName="";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User userDetails = (User) authentication.getPrincipal();
            Collection<GrantedAuthority> t = userDetails.getAuthorities();
            String auths = t.toString();
            System.out.println(auths);
            if(auths.contains("ROLE_ADMIN")) return "list/list";
        }
        return "userview/limitedlist";
    } 
    
    @PostMapping(path="/books/update",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateBook(@ModelAttribute("book") Book theBook){
        bookService.save(theBook);
        return "redirect:/books";
    }

//    @DeleteMapping(path="/books/delete", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public String deleteBook(@RequestParam(name="id")int theId){
//        System.out.println("ez az id");
//        bookService.deleteById(theId);
//        return "redirect:/books";
//    }
    @GetMapping("/books/delete")
    public String deleteBook(@ModelAttribute("book")Book theBook){
        System.out.println("ez az id"+theBook.getId());
        bookService.deleteById(theBook.getId());
        return "redirect:/books";
    }
}
