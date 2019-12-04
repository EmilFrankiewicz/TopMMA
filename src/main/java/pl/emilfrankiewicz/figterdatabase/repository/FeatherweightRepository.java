package pl.emilfrankiewicz.figterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.figterdatabase.model.FighterFeatherweight;

@Repository
public interface FeatherweightRepository extends JpaRepository<FighterFeatherweight, Long> {
}
