package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterBantamweight;

@Repository
public interface BantamweightRepository extends JpaRepository<FighterBantamweight, Long> {
}
