package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.Order;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.service.OrderService;
import mk.ukim.finki.lab.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrdersPage(@SessionAttribute User user, Model model){

        List<Order> orders = this.orderService.findByUserOrder(user.getId());
        model.addAttribute("orders", orders);

        return "userOrders";
    }

}
