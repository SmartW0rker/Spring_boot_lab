package com.mk.finki.ukim.mk.lab.repository.impl;

import com.mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import com.mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class InMemoryBalloonRepository {


    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;

    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream()
                .filter(r->{
                    return r.getName().contains(text) && r.getDescription().contains(text);
                }).collect(Collectors.toList());

    }
    public void save(Balloon balloon){
        DataHolder.balloons.removeIf(b->b.getName().equals(balloon.getName()));
        DataHolder.balloons.add(balloon);
        DataHolder.balloons.sort(Comparator.comparing(Balloon::getName));
    }
    public void delete(Long id){
        DataHolder.balloons.removeIf(b->b.getId().equals(id));
    }
}
