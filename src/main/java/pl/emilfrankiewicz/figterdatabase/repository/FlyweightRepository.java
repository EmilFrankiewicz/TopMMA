package pl.emilfrankiewicz.figterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.figterdatabase.model.FighterFlyweight;

@Repository
public interface FlyweightRepository extends JpaRepository<FighterFlyweight, Long> {
}
