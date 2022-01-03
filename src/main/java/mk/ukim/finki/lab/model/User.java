package mk.ukim.finki.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "balloonshop_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String surname;

    private String password;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    public User(){}

    public User(String username, String password, String name, String surname, String dateOfBirth) {

        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.carts = new ArrayList<>();
        this.dateOfBirth = LocalDate.parse(dateOfBirth);

    }

}
