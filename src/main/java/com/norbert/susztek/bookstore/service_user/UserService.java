package com.norbert.susztek.bookstore.service_user;

import com.norbert.susztek.bookstore.dao.UserRepository;
import com.norbert.susztek.bookstore.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByEmail(String email);
}
