package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Order;
import mk.ukim.finki.lab.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Order> listAllOrdersInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(Long id);

    ShoppingCart addOrderToShoppingCart(Long userId, Long orderId);

}
