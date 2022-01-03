package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Order;
import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.model.exceptions.CartNotFoundException;
import mk.ukim.finki.lab.model.exceptions.OrderNotFoundException;
import mk.ukim.finki.lab.model.exceptions.UserNotFoundException;
import mk.ukim.finki.lab.repository.impl.InMemoryOrderRepository;
import mk.ukim.finki.lab.repository.jpa.OrderRepository;
import mk.ukim.finki.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, User user) {
        if(balloonColor == null && balloonColor.isEmpty()){
            return null;
        }

        Order order = new Order(balloonColor, balloonSize, user);

        return this.orderRepository.save(order);
    }

    @Override
    public Optional<Order> findOrderById(Long id) {

        return Optional.of(this.orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException(id)));

    }

    @Override
    public List<Order> findByUserOrder(Long id) {

        if(this.orderRepository.findByUserOrder(id).isEmpty()){
            throw new UserNotFoundException(id);
        }

        List<Order> orders = new ArrayList<>();

        for(Order order:this.orderRepository.findAll()){

            if(order.getUserOrder().getId().equals(id)){
                orders.add(order);
            }

        }

        return orders;
    }

}
