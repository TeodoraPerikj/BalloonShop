package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Order;
import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order placeOrder(String balloonColor, String balloonSize, User user);

    Optional<Order> findOrderById(Long id);

    List<Order> findByUserOrder(Long id);

}
