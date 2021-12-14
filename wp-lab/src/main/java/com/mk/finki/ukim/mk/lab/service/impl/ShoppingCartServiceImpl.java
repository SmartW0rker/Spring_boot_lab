package com.mk.finki.ukim.mk.lab.service.impl;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.ShoppingCart;
import com.mk.finki.ukim.mk.lab.model.User;
import com.mk.finki.ukim.mk.lab.repository.jpa.ShoppingCartRepository;
import com.mk.finki.ukim.mk.lab.service.ShoppingCartService;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void save(User user, LocalDateTime dateCreated, List<Order> orders) {
        shoppingCartRepository.save(User,dateCreated,orders)
    }

    @Override
    public ShoppingCart findByUser(User user) {
        return
    }
}