package pl.emilfrankiewicz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.emilfrankiewicz.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
