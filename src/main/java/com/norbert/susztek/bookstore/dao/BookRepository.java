package com.norbert.susztek.bookstore.dao;


import com.norbert.susztek.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public List<Book> findAllByTitle(String title);
    public List<Book> findAllByAuthor(String author);
}
