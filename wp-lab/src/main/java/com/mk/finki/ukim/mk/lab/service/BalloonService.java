package com.mk.finki.ukim.mk.lab.service;

import com.mk.finki.ukim.mk.lab.model.Balloon;

import java.util.List;

public interface BalloonService {
    public List<Balloon> listAll();
    public List<Balloon> searchByNameOrDescription(String text);
    public void save(Balloon balloon);
    public void edit(Long id, String name, String description, Long manufacturerId);
    public void deleteById(Long id);
}

