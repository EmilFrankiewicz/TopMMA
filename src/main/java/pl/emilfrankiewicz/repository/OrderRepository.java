package pl.emilfrankiewicz.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.emilfrankiewicz.model.Order;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {

}
