package com.mk.finki.ukim.mk.lab.web.servlet;

import com.mk.finki.ukim.mk.lab.model.Order;
import com.mk.finki.ukim.mk.lab.model.User;
import com.mk.finki.ukim.mk.lab.service.OrderService;
import com.mk.finki.ukim.mk.lab.service.UserService;
import lombok.Data;
import lombok.SneakyThrows;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Config-servlet",urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final List<HttpSession> sessionList;
    private final SpringTemplateEngine springTemplateEngine;
    private final List<Order> orders;
    private final OrderService orderService;
    private final UserService userService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService, UserService userService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
        this.userService = userService;
        sessionList=new ArrayList<>();
        orders=new ArrayList<>();
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context=new WebContext(req,resp, req.getServletContext());

        Order order=new Order((String)req.getSession().getAttribute("size"),
                (String)req.getSession().getAttribute("color"));
        orderService.save(order);
        orders.add(order);

        String dateString=req.getParameter("dateTime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//surround below line with try catch block as below code throws checked exception
        Date date = sdf.parse(dateString);


        User user=userService.findByName(req.getParameter("clientName"));
        //if (user.getCarts().isEmpty())
        context.setVariable("clientAgent",req.getHeader("User-Agent"));
        context.setVariable("ipAdress",req.getRemoteAddr());
        req.getSession().setAttribute("orders",orders);
        req.getSession().setAttribute("user",user);
        req.getSession().setAttribute("date",sdf.format(date));

        this.springTemplateEngine.process("confirmationInfo.html",context,resp.getWriter());
    }
}
;