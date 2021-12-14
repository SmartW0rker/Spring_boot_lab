package com.mk.finki.ukim.mk.lab.exceptions;

public class BalloonNotFoundExeption extends RuntimeException{
    public BalloonNotFoundExeption(Long id) {
        super(String.format("Balloon with id: %d not found",id));
    }
}
