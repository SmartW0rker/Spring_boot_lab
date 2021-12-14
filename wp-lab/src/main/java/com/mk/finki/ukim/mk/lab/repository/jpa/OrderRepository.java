package com.mk.finki.ukim.mk.lab.repository.jpa;

import com.mk.finki.ukim.mk.lab.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Long> {
    Optional<Order> findByOrderId(Long id);
}
