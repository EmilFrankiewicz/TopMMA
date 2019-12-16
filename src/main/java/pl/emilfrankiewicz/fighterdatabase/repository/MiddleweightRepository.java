package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterMiddleweight;

@Repository
public interface MiddleweightRepository extends JpaRepository<FighterMiddleweight, Long> {
}
