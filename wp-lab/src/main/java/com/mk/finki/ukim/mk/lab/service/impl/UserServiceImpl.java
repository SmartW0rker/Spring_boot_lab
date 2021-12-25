package com.mk.finki.ukim.mk.lab.service.impl;

import com.mk.finki.ukim.mk.lab.exceptions.UserNotFound;
import com.mk.finki.ukim.mk.lab.model.User;
import com.mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import com.mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).orElse(null);
               // .orElseThrow(()-> new UserNotFound(name));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
