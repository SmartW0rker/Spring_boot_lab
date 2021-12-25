package com.mk.finki.ukim.mk.lab.service;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.ShoppingCart;
import com.mk.finki.ukim.mk.lab.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ShoppingCartService {
    public void save(User user, LocalDateTime dateCreated, List<Order> orders);
    public ShoppingCart findByUserId(Long id);

    void save(ShoppingCart cart);
}
