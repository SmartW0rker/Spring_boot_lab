package com.mk.finki.ukim.mk.lab.repository.jpa;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.ShoppingCart;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Long> {
    Optional<Order> findByOrderId(Long id);
    Optional<List<Order>> findAllByCartId(Long id);
}
