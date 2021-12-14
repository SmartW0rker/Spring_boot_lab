package com.mk.finki.ukim.mk.lab.exceptions;

public class ManufacturerNotFound extends RuntimeException{
    public ManufacturerNotFound(Long id) {
        super(String.format("Manufacturer with id: %d not found",id));
    }
}
