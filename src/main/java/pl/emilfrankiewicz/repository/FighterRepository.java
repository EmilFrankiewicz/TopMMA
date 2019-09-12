package pl.emilfrankiewicz.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.model.Fighter;

@Repository
@Transactional
public interface FighterRepository extends CrudRepository<Fighter, Long> {
}
