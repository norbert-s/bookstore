package com.norbert.susztek.bookstore.service;

import com.norbert.susztek.bookstore.dao.BookRepository;
import com.norbert.susztek.bookstore.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> findAllByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    @Override
    public List<Book> findAllByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }


}
