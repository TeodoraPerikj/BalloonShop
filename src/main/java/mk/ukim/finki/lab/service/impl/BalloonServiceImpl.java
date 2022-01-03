package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Balloon;
import mk.ukim.finki.lab.model.Manufacturer;
import mk.ukim.finki.lab.repository.impl.InMemoryBalloonRepository;
import mk.ukim.finki.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final InMemoryBalloonRepository balloonRepository;

    public BalloonServiceImpl(InMemoryBalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if(text == null || text.isEmpty()){
            return null;
        }

        return this.balloonRepository.findAllByNameOrDescription(text);

    }

    @Override
    public Balloon saveOrUpdate(String name, String description, Manufacturer manufacturer) {

        if(name == null || name.isEmpty()) return null;

        this.balloonRepository.delete(name);

        return this.balloonRepository.saveOrUpdate(name, description, manufacturer);
    }

    @Override
    public void delete(String name) {

        if(name == null || name.isEmpty()) return;

        this.balloonRepository.delete(name);

    }

    @Override
    public void deleteById(Long id) {
        if(id == null) return;

        this.balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }
}
