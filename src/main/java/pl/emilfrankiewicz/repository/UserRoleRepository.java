package pl.emilfrankiewicz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.emilfrankiewicz.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}