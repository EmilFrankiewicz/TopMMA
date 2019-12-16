package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterLightHeavyweight;

@Repository
public interface LightHeavyweightRepository extends JpaRepository<FighterLightHeavyweight, Long> {

}
