package mk.ukim.finki.lab.repository.impl;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Order;
import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryOrderRepository {

    public Order saveOrUpdate(String balloonColor, String balloonSize, User user){

        DataHolder.orders.removeIf(order -> order.getBalloonColor().equals(balloonColor)
                && order.getUserOrder().getUsername().equals(user.getUsername()));

        Order order = new Order(balloonColor, balloonSize, user);

        DataHolder.orders.add(order);

        return order;
    }

    public void delete(String balloonColor, User user){
        DataHolder.orders.removeIf(order -> order.getBalloonColor().equals(balloonColor)
                && order.getUserOrder().getUsername().equals(user.getUsername()));
    }

    public Optional<Order> findOrderByColorAndName(String balloonColor, User user){

        return DataHolder.orders.stream().filter(order -> order.getBalloonColor().equals(balloonColor)
                && order.getUserOrder().getUsername().equals(user.getUsername())).findFirst();

    }

}
