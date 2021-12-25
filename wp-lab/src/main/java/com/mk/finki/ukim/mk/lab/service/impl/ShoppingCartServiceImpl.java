package com.mk.finki.ukim.mk.lab.service.impl;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.ShoppingCart;
import com.mk.finki.ukim.mk.lab.model.User;
import com.mk.finki.ukim.mk.lab.repository.jpa.ShoppingCartRepository;
import com.mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void save(User user, LocalDateTime dateCreated, List<Order> orders) {
        ShoppingCart cart=new ShoppingCart(user,dateCreated,orders);
        shoppingCartRepository.save(cart);
    }

    @Override
    public ShoppingCart findByUserId(Long id) {
        return shoppingCartRepository.findByUserId(id).orElse(null);
    }

    @Override
    public void save(ShoppingCart cart) {
        shoppingCartRepository.save(cart);
    }
}
