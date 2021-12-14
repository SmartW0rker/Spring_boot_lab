package com.mk.finki.ukim.mk.lab.service.impl;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.repository.jpa.OrderRepository;
import com.mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findByOrderId(Long id) {
        return orderRepository.findByOrderId(id);
    }

   @Override
    public void save(Order order) {
       orderRepository.save(order);
   }


}
