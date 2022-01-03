package mk.ukim.finki.lab.repository.impl;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Balloon;
import mk.ukim.finki.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBalloonRepository {

    public List<Balloon> findAll(){
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){

        return DataHolder.balloons.stream().filter(balloon -> balloon.getName().contains(text)
                || balloon.getDescription().contains(text)).collect(Collectors.toList());

    }

    public Balloon saveOrUpdate(String name, String description, Manufacturer manufacturer){

        DataHolder.balloons.removeIf(balloon -> balloon.getName().equals(name));

        Balloon balloon = new Balloon(name, description, manufacturer);

        DataHolder.balloons.add(balloon);

        return balloon;

    }

    public void delete(String name){
        DataHolder.balloons.removeIf(balloon -> balloon.getName().equals(name));
    }

    public void deleteById(Long id){
        DataHolder.balloons.removeIf(balloon -> balloon.getId().equals(id));
    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloons.stream().filter(balloon -> balloon.getId().equals(id)).findFirst();
    }

}
