package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Manufacturer;
import mk.ukim.finki.lab.repository.impl.InMemoryManufacturerRepository;
import mk.ukim.finki.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    public Manufacturer saveOrUpdate(String name, String country, String address) {
        if(name == null || name.isEmpty()) return null;

        return this.manufacturerRepository.saveOrUpdate(name, country, address);
    }

    @Override
    public void delete(String name) {

        if(name == null || name.isEmpty()) return;

        this.manufacturerRepository.delete(name);

    }

    @Override
    public void deleteById(Long id) {
        if(id == null) return;

        this.manufacturerRepository.deleteById(id);
    }
}
