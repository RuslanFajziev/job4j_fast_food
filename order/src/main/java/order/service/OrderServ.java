package order.service;

import order.model.Order;
import order.model.OrderDTO;
import order.repository.OrderProductRepos;
import order.repository.OrderRepos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServ {
    private static final Logger LOG = LoggerFactory.getLogger(OrderServ.class.getSimpleName());

    private final OrderRepos orderRepos;
    private final OrderProductRepos orderProductRepos;

    public OrderServ(OrderRepos orderRepos, OrderProductRepos orderProductRepos) {
        this.orderRepos = orderRepos;
        this.orderProductRepos = orderProductRepos;
    }

    public Order makeOrder(OrderDTO orderDTO) {
        Order orderNew = Order.of(orderDTO.getProductSet());
        orderNew.setStatus("issued");
        return orderRepos.save(orderNew);
    }

    public Map<String, String> cancelOrder(int id) {
        orderRepos.cancelOrder(id);
        orderProductRepos.delOrderProductint(id);
        Optional<Order> order = orderRepos.findById(id);
        Map<String, String> rsl = new HashMap<>();
        rsl.put("order id", String.valueOf(id));
        rsl.put("status", order.get().getStatus());
        return rsl;
    }

    public Map<String, String> getStatusOrder(int id) {
        Map<String, String> rsl = new HashMap<>();
        Optional<Order> order = orderRepos.findById(id);
        if (order.isPresent()) {
            rsl.put("order id", String.valueOf(id));
            rsl.put("status", order.get().getStatus());
        } else {
            rsl.put("order id", String.valueOf(id));
            rsl.put("status", "not found");
        }
        return rsl;
    }
}
