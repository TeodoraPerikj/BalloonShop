package mk.ukim.finki.lab.model.exceptions;

public class OrderAlreadyInShoppingCartException extends RuntimeException {
    public OrderAlreadyInShoppingCartException(Long orderId, Long userId) {
        super(String.format("Order with id %d for user with id %d already in shopping cart",orderId, userId));
    }
}
