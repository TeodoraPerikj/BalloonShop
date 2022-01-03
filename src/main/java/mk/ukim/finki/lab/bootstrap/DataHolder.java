package mk.ukim.finki.lab.bootstrap;

import mk.ukim.finki.lab.model.Balloon;
import mk.ukim.finki.lab.model.Manufacturer;
import mk.ukim.finki.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

//    @PostConstruct
//    public void init(){
//
//        Manufacturer manufacturer = new Manufacturer("Preplet", "Macedonia", "Skopje");
//
//       balloons.add(new Balloon("Red", "Red description", manufacturer));
//       balloons.add(new Balloon("Blue", "Blue description", manufacturer));
//       balloons.add(new Balloon("Yellow", "Yellow description", manufacturer));
//       balloons.add(new Balloon("Green", "Green description", manufacturer));
//       balloons.add(new Balloon("Pink", "Pink description", manufacturer));
//       balloons.add(new Balloon("Orange", "Orange description", manufacturer));
//       balloons.add(new Balloon("Purple", "Purple description", manufacturer));
//       balloons.add(new Balloon("White", "White description", manufacturer));
//       balloons.add(new Balloon("Black", "Black description", manufacturer));
//       balloons.add(new Balloon("Brown", "Brown description", manufacturer));
//
//       manufacturers.add(manufacturer);
//       manufacturers.add(new Manufacturer("ZARA", "Macedonia", "Skopje"));
//       manufacturers.add(new Manufacturer("DISNEY", "Macedonia", "Skopje"));
//        manufacturers.add(new Manufacturer("TRI", "Macedonia", "Skopje"));
//        manufacturers.add(new Manufacturer("H&M", "Macedonia", "Skopje"));
//
//    }
}
