package pl.emilfrankiewicz.figterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.figterdatabase.model.FighterLightHeavyweight;

@Repository
public interface LightHeavyweightRepository extends JpaRepository<FighterLightHeavyweight, Long> {

}
