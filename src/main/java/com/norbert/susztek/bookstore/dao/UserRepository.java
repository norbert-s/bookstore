package com.norbert.susztek.bookstore.dao;

import com.norbert.susztek.bookstore.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
