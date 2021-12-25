package com.mk.finki.ukim.mk.lab.web.controller;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.ShoppingCart;
import com.mk.finki.ukim.mk.lab.model.User;
import com.mk.finki.ukim.mk.lab.service.OrderService;
import com.mk.finki.ukim.mk.lab.service.ShoppingCartService;
import com.mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderService orderService;

    public OrderController(ShoppingCartService shoppingCartService, UserService userService, OrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping
    public String userOrders(HttpSession session, Model model){
        User user=(User)session.getAttribute("user");
        List<Order> orderList=new ArrayList<>();
        if (user.getCarts().isEmpty()) {
            System.out.println("pass");
            shoppingCartService.save(user,LocalDateTime.now(),orderList);
            ShoppingCart cart=shoppingCartService.findByUserId(user.getId());

            user.getCarts().add(cart);
            userService.save(user);
        }
        ShoppingCart cart=shoppingCartService.findByUserId(user.getId());
        Order thisOrder=(Order) session.getAttribute("thisOrder");
        System.out.println(cart.toString());
        thisOrder.setCart(cart);
        orderService.save(thisOrder);
        cart.getOrders().add(thisOrder);
        shoppingCartService.save(cart);

        model.addAttribute("user",user);
        model.addAttribute("orderList",orderService.findByCardId(cart.getId()));

        return "userOrders";
    }
}
