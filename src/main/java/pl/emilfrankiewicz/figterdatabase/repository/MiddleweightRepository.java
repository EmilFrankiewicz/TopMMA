package pl.emilfrankiewicz.figterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.figterdatabase.model.FighterMiddleweight;

@Repository
public interface MiddleweightRepository extends JpaRepository<FighterMiddleweight, Long> {
}
