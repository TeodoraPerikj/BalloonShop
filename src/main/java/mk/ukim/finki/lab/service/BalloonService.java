package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Balloon;
import mk.ukim.finki.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface BalloonService {

    List<Balloon> listAll();

    List<Balloon> searchByNameOrDescription(String text);

    Balloon saveOrUpdate(String name, String description, Manufacturer manufacturer);

    void delete(String name);

    void deleteById(Long id);

    Optional<Balloon> findById(Long id);
}
