package pl.emilfrankiewicz.figterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.emilfrankiewicz.figterdatabase.model.FighterHeavyweight;

@Repository
public interface HeavyweightRepository extends JpaRepository<FighterHeavyweight, Long> {
}
