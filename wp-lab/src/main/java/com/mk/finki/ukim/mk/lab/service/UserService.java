package com.mk.finki.ukim.mk.lab.service;

import com.mk.finki.ukim.mk.lab.model.User;

public interface UserService {
    User findByName(String name);
}
