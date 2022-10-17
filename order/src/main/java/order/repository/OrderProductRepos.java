package order.repository;

import order.model.OrderProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderProductRepos extends CrudRepository<OrderProduct, Integer> {
    @Modifying
    @Transactional
    @Query("delete from OrderProduct op where op.orderId = :idOrder")
    int delOrderProductint(int idOrder);
}
