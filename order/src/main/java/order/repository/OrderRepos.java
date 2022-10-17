package order.repository;

import order.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepos extends CrudRepository<Order, Integer> {
    @Modifying
    @Transactional
    @Query("update Order o set o.status = 'cancelled' where o.id = :orderId")
    int cancelOrder(int orderId);
}