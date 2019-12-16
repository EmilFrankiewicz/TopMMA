package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterHeavyweight;

@Repository
public interface HeavyweightRepository extends JpaRepository<FighterHeavyweight, Long> {
}
