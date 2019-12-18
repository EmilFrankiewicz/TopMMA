package pl.emilfrankiewicz.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findByNickname(String nickname);
}
