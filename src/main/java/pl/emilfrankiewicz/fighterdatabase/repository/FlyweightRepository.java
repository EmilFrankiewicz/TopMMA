package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFlyweight;

@Repository
public interface FlyweightRepository extends JpaRepository<FighterFlyweight, Long> {
}
