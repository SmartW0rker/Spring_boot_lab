package com.mk.finki.ukim.mk.lab.service;

import com.mk.finki.ukim.mk.lab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findByOrderId(Long id);

    void save(Order order);
    List<Order> findByCardId(Long id);
}
