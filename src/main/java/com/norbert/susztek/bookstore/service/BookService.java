package com.norbert.susztek.bookstore.service;


import com.norbert.susztek.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService  {
    public List<Book> findAllByTitle(String title);
    public List<Book> findAllByAuthor(String author);
    public List<Book> findAll();
    public Book save(Book theBook);
    public List<Book> findAllByOrderByAuthor();
    public List<Book> findAllByOrderByTitle();
    public Book findById(int id);
}
