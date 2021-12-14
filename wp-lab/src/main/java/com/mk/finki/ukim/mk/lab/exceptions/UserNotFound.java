package com.mk.finki.ukim.mk.lab.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String name) {
        super(String.format("User with name: %d not found",name));
    }
}
