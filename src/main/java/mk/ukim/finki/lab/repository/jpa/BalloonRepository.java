package mk.ukim.finki.lab.repository.jpa;

import mk.ukim.finki.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {
}
