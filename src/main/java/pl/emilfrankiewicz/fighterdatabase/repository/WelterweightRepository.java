package pl.emilfrankiewicz.fighterdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.fighterdatabase.model.FighterWelterweight;

@Repository
public interface WelterweightRepository extends JpaRepository<FighterWelterweight, Long> {
}
