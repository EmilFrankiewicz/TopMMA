package pl.emilfrankiewicz.figterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.figterdatabase.model.FighterBantamweight;

@Repository
public interface BantamweightRepository extends JpaRepository<FighterBantamweight, Long> {
}
