package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterFeatherweight;

@Repository
public interface FeatherweightRepository extends JpaRepository<FighterFeatherweight, Long> {
}
