package mk.ukim.finki.lab.model;

import lombok.Data;
import mk.ukim.finki.lab.model.enumeration.ShoppingCartStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    public ShoppingCart(){}

    public ShoppingCart(User user) {

        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.orders = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }

}
