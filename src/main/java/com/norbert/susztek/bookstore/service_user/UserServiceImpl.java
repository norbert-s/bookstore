package com.norbert.susztek.bookstore.service_user;

import com.norbert.susztek.bookstore.dao.UserRepository;
import com.norbert.susztek.bookstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl  implements UserService, UserDetailsService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("finding user is in progress");
        User user = findByEmail(username);
        if( user == null ){
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(user);
    }
}
