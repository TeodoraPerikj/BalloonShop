package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Order;
import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.model.enumeration.ShoppingCartStatus;
import mk.ukim.finki.lab.model.exceptions.CartNotFoundException;
import mk.ukim.finki.lab.model.exceptions.OrderAlreadyInShoppingCartException;
import mk.ukim.finki.lab.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.lab.model.exceptions.UserNotFoundException;
import mk.ukim.finki.lab.repository.jpa.OrderRepository;
import mk.ukim.finki.lab.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.lab.repository.jpa.UserRepository;
import mk.ukim.finki.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> listAllOrdersInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new CartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getOrders();

    }

    @Override
    public ShoppingCart getActiveShoppingCart(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });

    }

    @Override
    public ShoppingCart addOrderToShoppingCart(Long userId, Long orderId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(userId);
        Order order = this.orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        if(shoppingCart.getOrders()
                .stream().filter(i -> i.getOrderId().equals(orderId))
                .collect(Collectors.toList()).size() > 0)
            throw new OrderAlreadyInShoppingCartException(orderId, userId);
        shoppingCart.getOrders().add(order);
        return this.shoppingCartRepository.save(shoppingCart);

    }
}
