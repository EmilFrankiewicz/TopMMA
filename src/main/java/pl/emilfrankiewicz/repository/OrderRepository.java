package pl.emilfrankiewicz.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.model.Order;
import pl.emilfrankiewicz.model.User;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

	Order getByIdAndUser(Long id, User user);

	List<Order> getAllByUser(User user);
	
	@Modifying
	@Query("DELETE FROM Order" + " WHERE id_order=:idOrder" + " and user_id=:userId")
	void deleteUserFavoriteFighter(@Param("idOrder") Long idOrder, @Param("userId") Long userId);

}
