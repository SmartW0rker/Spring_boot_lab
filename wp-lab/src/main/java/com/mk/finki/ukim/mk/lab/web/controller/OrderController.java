package com.mk.finki.ukim.mk.lab.web.controller;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.User;
import com.mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;

    public OrderController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String userOrders(HttpSession session, Model model){
        User user=(User)session.getAttribute("user");
        List<Order> orderList=new ArrayList<>();
        if (user.getCarts().isEmpty()) {

            shoppingCartService.save(user,LocalDateTime.now(),orderList);

            //user.getCarts().add(User, )
        }
      //  model.addAttribute("balloonOrders",user.getCarts().);
        return "userOrders";
    }
}
