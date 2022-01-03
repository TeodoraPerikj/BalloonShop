package mk.ukim.finki.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String balloonColor;

    private String balloonSize;

    @ManyToOne
    private User userOrder;

    public Order(){}

    public Order(String balloonColor, String balloonSize, User user){

        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.userOrder = user;

    }

}
