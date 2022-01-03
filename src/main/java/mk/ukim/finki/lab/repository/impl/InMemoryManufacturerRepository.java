package mk.ukim.finki.lab.repository.impl;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }

    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream()
                .filter(manufacturer -> manufacturer.getId().equals(id)).findFirst();
    }

    public Manufacturer saveOrUpdate(String name, String country, String address){
        DataHolder.manufacturers.removeIf(manufacturer -> manufacturer.getName().equals(name));

        Manufacturer manufacturer = new Manufacturer(name, country, address);

        DataHolder.manufacturers.add(manufacturer);

        return manufacturer;
    }

    public void delete(String name){
        DataHolder.manufacturers.removeIf(manufacturer -> manufacturer.getName().equals(name));
    }

    public void deleteById(Long id){
        DataHolder.manufacturers.removeIf(manufacturer -> manufacturer.getId().equals(id));
    }

}
