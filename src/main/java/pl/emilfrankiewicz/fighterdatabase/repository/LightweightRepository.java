package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightweight;

@Repository
public interface LightweightRepository extends JpaRepository<FighterLightweight, Long> {
}
