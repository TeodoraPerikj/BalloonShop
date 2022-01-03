package mk.ukim.finki.lab.model.exceptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(Long id) {
        super(String.format("Cart with id %d not found",id));
    }
}
